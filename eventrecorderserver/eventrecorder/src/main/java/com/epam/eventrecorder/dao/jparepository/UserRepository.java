package com.epam.eventrecorder.dao.jparepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.epam.eventrecorder.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Override
    User findOne(Integer Id);

    @Override
    List<User> findAll();
}
