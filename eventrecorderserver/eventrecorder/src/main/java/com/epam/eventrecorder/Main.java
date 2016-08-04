package com.epam.eventrecorder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.epam.eventrecorder.dao.UserDao;
import com.epam.eventrecorder.domain.User;
import com.epam.eventrecorder.userlist.view.model.UserSummary;
import com.epam.eventrecorder.userlist.view.transformer.UserToUserSummaryTransformer;

@RestController
@ComponentScan
@EnableAutoConfiguration
// @SpringBootApplication
public class Main {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    Valami home() {
        return new Valami(5, "valami");
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<UserSummary> users() {
        UserToUserSummaryTransformer userSummaryTransformer = new UserToUserSummaryTransformer();
        List<User> testUsers = userDao.getUsers();
        // List<User> testUsers = new ArrayList<>();
        // testUsers.add(new User("First test user"));
        // testUsers.add(new User("Second test user"));
        // testUsers.get(0).setId(0);
        // testUsers.get(1).setId(1);
        return userSummaryTransformer.transformUsersToSummaries(testUsers);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Main.class, args);
    }

}

class Valami {
    private int a;
    private String b;

    public Valami(int a, String b) {
        this.a = a;
        this.b = b;
    }

}