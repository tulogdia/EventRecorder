package com.epam.eventrecorder.userlist.view.transformer;

import java.util.ArrayList;
import java.util.List;

import com.epam.eventrecorder.domain.User;
import com.epam.eventrecorder.userlist.view.model.UserSummary;

public class UserToUserSummaryTransformer {

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

}
