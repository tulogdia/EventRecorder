package com.epam.training.eventrecorder.dao;

import java.util.List;

import com.epam.training.eventrecorder.domain.User;

public interface UserDao {

    public List<User> getUsers();

    public void saveUser(User user);

    public void deleteUser(User user);
}
