package com.epam.eventrecorder.userlist.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.epam.eventrecorder.user.service.AddUserService;

@RestController
public class AddUserController {

    @Autowired
    private AddUserService addUserService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    void addUser(@RequestBody String name) {
        addUserService.addUser(name);
    }

}
