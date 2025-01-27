package com.application.task_manager.factories;

import com.application.task_manager.models.Role;
import com.application.task_manager.models.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserFactory {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static User createUser(int id, String firstName, String lastName, String email, String username, String password, Role role, String createTime) {
        User user = new User();
        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);
        user.setCreateTime(LocalDateTime.parse(createTime, formatter));
        return user;
    }

    public static User createUser2(String firstName, String lastName, String email, String username, String password) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }
}