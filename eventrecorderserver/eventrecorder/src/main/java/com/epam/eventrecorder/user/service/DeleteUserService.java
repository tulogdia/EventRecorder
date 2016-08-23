package com.epam.eventrecorder.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.eventrecorder.user.dao.UserDao;

@Service
public class DeleteUserService {

    @Autowired
    private UserDao userDao;

    public void deleteUser(Long userId) {
        userDao.deleteUser(userId);
    }
}
