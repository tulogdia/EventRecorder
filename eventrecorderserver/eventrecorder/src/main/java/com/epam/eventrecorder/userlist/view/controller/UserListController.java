package com.epam.eventrecorder.userlist.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.epam.eventrecorder.dao.UserDao;
import com.epam.eventrecorder.domain.User;
import com.epam.eventrecorder.userlist.view.model.UserSummary;
import com.epam.eventrecorder.userlist.view.transformer.UserToUserSummaryTransformer;

@RestController
public class UserListController {

    @Autowired
    private UserDao userDao;

    @Autowired
    UserToUserSummaryTransformer userSummaryTransformer;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<UserSummary> users() {
        List<User> Users = userDao.getUsers();
        return userSummaryTransformer.transformUsersToSummaries(Users);
    }
}