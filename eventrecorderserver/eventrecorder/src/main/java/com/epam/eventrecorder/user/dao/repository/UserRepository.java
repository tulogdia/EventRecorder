package com.epam.eventrecorder.user.dao.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.epam.eventrecorder.user.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

    @Override
    List<User> findAll();

}