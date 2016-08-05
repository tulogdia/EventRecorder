package com.epam.eventrecorder.user.dao.jpaimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.epam.eventrecorder.user.dao.UserDao;
import com.epam.eventrecorder.user.dao.repository.UserRepository;
import com.epam.eventrecorder.user.domain.User;

@Repository("userDao")
public class JpaUserDao implements UserDao {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Integer userId) {
        return userRepository.findOne(userId);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        // TODO Auto-generated method stub

    }

}