package com.epam.eventrecorder.userlist.view.transformer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.eventrecorder.dao.UserDao;
import com.epam.eventrecorder.domain.User;
import com.epam.eventrecorder.userlist.view.model.UserSummary;

@Component
public class UserSummaryTransformer {

    @Autowired
    UserDao userDao;

    public List<UserSummary> transformUsersToSummaries(List<User> users) {
        List<UserSummary> result = new ArrayList<>();
        for (User user : users) {
            result.add(transformUserToSummary(user));
        }
        return result;
    }

    public UserSummary transformUserToSummary(User user) {
        UserSummary result = new UserSummary();
        result.setId(user.getId());
        result.setName(user.getName());
        return result;
    }

    public User transformUserSummaryToUser(UserSummary userSummary) {
        User result = userDao.findUserById(userSummary.getId());
        result.setName(userSummary.getName());
        return result;
    }

}
