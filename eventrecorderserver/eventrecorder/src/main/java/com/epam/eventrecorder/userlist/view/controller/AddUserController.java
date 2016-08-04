package com.epam.eventrecorder.userlist.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.epam.eventrecorder.dao.UserDao;
import com.epam.eventrecorder.domain.User;
import com.epam.eventrecorder.userlist.view.model.UserSummary;
import com.epam.eventrecorder.userlist.view.transformer.UserSummaryTransformer;

@RestController
public class AddUserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    UserSummaryTransformer userSummaryTransformer;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    void users(@RequestBody UserSummary userSummary) {
        User user = userSummaryTransformer.transformUserSummaryToUser(userSummary);
        userDao.saveUser(user);
    }
}
