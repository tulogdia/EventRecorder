package com.epam.eventrecorder.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("com.epam.eventrecorder")
@EnableTransactionManagement
public class SpringDataSourceConfiguration {

    @Bean
    public DataSource dataSource() {
        return new DriverManagerDataSource("jdbc:mysql://localhost:3306/eventrecorderserver", "root", "root");
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[] { "com.epam.eventrecorder" });

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());

        return em;
    }

    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        return properties;
    }

    // @Bean
    // public EntityManagerFactory entityManagerFactory() {
    //
    // HibernateJpaVendorAdapter vendorAdapter = new
    // HibernateJpaVendorAdapter();
    // vendorAdapter.setGenerateDdl(true);
    //
    // LocalContainerEntityManagerFactoryBean factory = new
    // LocalContainerEntityManagerFactoryBean();
    // factory.setJpaVendorAdapter(vendorAdapter);
    // factory.setPackagesToScan("com.epam.eventrecorder");
    // factory.setDataSource(dataSource());
    // factory.afterPropertiesSet();
    //
    // return factory.getObject();
    // }
    //
    // @Bean
    // public PlatformTransactionManager transactionManager() {
    //
    // JpaTransactionManager txManager = new JpaTransactionManager();
    // txManager.setEntityManagerFactory(entityManagerFactory());
    // return txManager;
    // }
}
