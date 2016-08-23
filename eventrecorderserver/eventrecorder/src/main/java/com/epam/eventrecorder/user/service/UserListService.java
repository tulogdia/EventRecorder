package com.epam.eventrecorder.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.eventrecorder.user.dao.UserDao;
import com.epam.eventrecorder.user.domain.User;

@Service
public class UserListService {

    @Autowired
    private UserDao userDao;

    public List<User> getUsers() {
        return userDao.getUsers();
    }

    public User findUserById(Long userId) {
        return userDao.findUserById(userId);
    }

}
