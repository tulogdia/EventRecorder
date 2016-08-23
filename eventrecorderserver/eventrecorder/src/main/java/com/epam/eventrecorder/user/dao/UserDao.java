package com.epam.eventrecorder.user.dao;

import java.util.List;

import com.epam.eventrecorder.user.domain.User;

public interface UserDao {

    public List<User> getUsers();

    public User findUserById(Long userId);

    public User saveUser(User user);

    public void deleteUser(Long userId);

}
