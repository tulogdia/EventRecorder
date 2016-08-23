package com.epam.eventrecorder.userlist.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.epam.eventrecorder.user.service.DeleteUserService;

@RestController
public class DeleteUserController {

    @Autowired
    private DeleteUserService deleteUserService;

    @RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    void deleteUser(@RequestBody Long userId) {
        System.out.println("Delete user by id: " + userId);
        deleteUserService.deleteUser(userId);
    }

}
