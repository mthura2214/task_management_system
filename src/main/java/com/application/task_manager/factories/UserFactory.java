package com.application.task_manager.factories;

import com.application.task_manager.models.User;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserFactory {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static User createUser(int id, String firstName, String lastName, String username, String password, String email, User.Role role, String createTime) {
        User user = new User();
        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setRole(role);
        user.setCreateTime(LocalDateTime.parse(createTime, formatter));
        return user;
    }

    public static User createUser(String firstName, String lastName, String username, String password, String email) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        return user;
    }
}