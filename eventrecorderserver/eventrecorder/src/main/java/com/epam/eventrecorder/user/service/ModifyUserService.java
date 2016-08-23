package com.epam.eventrecorder.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.eventrecorder.user.dao.UserDao;
import com.epam.eventrecorder.user.domain.User;

@Service
public class ModifyUserService {

    @Autowired
    private UserDao userDao;

    public void modifyUser(User user) {
        userDao.saveUser(user);
    }

}
