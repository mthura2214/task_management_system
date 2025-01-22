package com.application.task_manager.factories;

import com.application.task_manager.models.User;
import com.application.task_manager.models.User.Role;

import java.time.LocalDateTime;

public class UserFactory {


     //Creates a new User instance with the given details.

    public static User createUser(String firstName, String lastName, String username, String password, String email, Role role) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(username);
        user.setPassword(password); // Ensure password is already hashed before calling this method
        user.setEmail(email);
        user.setRole(role != null ? role : Role.USER); // Default to USER if no role is provided
        //user.setCreateTime(LocalDateTime.now()); // Automatically set the creation time
        return user;
    }

     //Creates a new User instance with default role USER.

    public static User createUserWithDefaultRole(String firstName, String lastName, String username, String password, String email) {
        return createUser(firstName, lastName, username, password, email, Role.USER);
    }
}
