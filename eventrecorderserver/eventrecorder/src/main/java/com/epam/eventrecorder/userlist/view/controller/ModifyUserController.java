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
public class ModifyUserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserSummaryTransformer userSummaryTransformer;

    @RequestMapping(value = "/modifyUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    void modifyUser(@RequestBody UserSummary userSummary) {
        User user = userSummaryTransformer.transformUserSummaryToUser(userSummary);
        userDao.saveUser(user);
    }
}
