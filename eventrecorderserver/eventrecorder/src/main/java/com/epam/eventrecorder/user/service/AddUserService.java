package com.epam.eventrecorder.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.eventrecorder.user.dao.UserDao;
import com.epam.eventrecorder.user.domain.User;

@Service
public class AddUserService {

    @Autowired
    UserDao userDao;

    public void addUser(String name) {
        User user = new User();
        user.setName(name);
        userDao.saveUser(user);
    }

}
