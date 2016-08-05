package com.epam.eventrecorder.userlist.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.epam.eventrecorder.user.dao.UserDao;
import com.epam.eventrecorder.user.domain.User;
import com.epam.eventrecorder.userlist.view.model.UserSummary;
import com.epam.eventrecorder.userlist.view.transformer.UserSummaryTransformer;

@RestController
public class UserListController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserSummaryTransformer userSummaryTransformer;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<UserSummary> users() {
        List<User> users = userDao.getUsers();
        return userSummaryTransformer.transformUsersToSummaries(users);
    }
}