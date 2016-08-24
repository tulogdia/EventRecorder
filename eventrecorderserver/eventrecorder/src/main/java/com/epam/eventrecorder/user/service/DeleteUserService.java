package com.epam.eventrecorder.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.eventrecorder.user.dao.UserDao;
import com.epam.eventrecorder.user.domain.User;

@Service
public class DeleteUserService {

    @Autowired
    private UserDao userDao;

    public void deleteUser(Long userId) {
        User user = userDao.findUserById(userId);
        if (user.getExperiments().isEmpty() && user.getKeysets().isEmpty()) {
            userDao.deleteUser(userId);
        } else {
            throw new IllegalArgumentException("User " + user + " can not be deleted. Delete experiments and keysets before.");
        }

    }
}
