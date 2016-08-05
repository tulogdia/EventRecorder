package com.epam.eventrecorder.userlist.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.epam.eventrecorder.user.dao.UserDao;
import com.epam.eventrecorder.user.domain.User;

@RestController
public class AddUserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    void addUser(@RequestBody String name) {
        User user = new User();
        user.setName(name);
        userDao.saveUser(user);
    }

}
