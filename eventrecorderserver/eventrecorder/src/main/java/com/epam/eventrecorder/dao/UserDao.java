package com.epam.eventrecorder.dao;

import java.util.List;

import com.epam.eventrecorder.domain.User;

public interface UserDao {

    public List<User> getUsers();

    public User findUserById(Integer userId);

    public void saveUser(User user);

    public void deleteUser(User user);
}
