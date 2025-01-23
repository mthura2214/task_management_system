package com.application.task_manager.controllers;

import com.application.task_manager.factories.UserFactory;
import com.application.task_manager.models.Role;
import com.application.task_manager.models.User;
import com.application.task_manager.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        user = UserFactory.createUser(2, "John", "Doe", "asi.doe@example.com", "password123", Role.USER, "2023-10-10 10:10:10");
    }

    @Test
    void getAllUsers() {
        List<User> users = Collections.singletonList(user);
        when(userService.findAllUsers()).thenReturn(users);

        ResponseEntity<List<User>> response = userController.getAllUsers();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(users, response.getBody());
        System.out.printf("Users: %s\n", response.getBody());
    }

    @Test
    void getUserById() {
        when(userService.findUserById(1)).thenReturn(user);

        ResponseEntity<User> response = userController.getUserById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
        System.out.printf("User ID: %s\n", response.getBody());
    }

    @Test
    void getUserByEmail() {
        when(userService.findUserByEmail("john.doe@example.com")).thenReturn(user);

        ResponseEntity<User> response = userController.getUserByEmail("john.doe@example.com");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
        System.out.printf("User Email: %s\n", response.getBody());
    }

    @Test
    void createUser() {
        when(userService.createUser(user)).thenReturn(user);

        ResponseEntity<User> response = userController.createUser(user);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(user, response.getBody());
        System.out.printf("Created user: %s\n", response.getBody());
    }

    @Test
    @Disabled
    void updateUser() {
        when(userService.updateUser(1, user)).thenReturn(user);

        ResponseEntity<User> response = userController.updateUser(1, user);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
        System.out.printf("Updated user: %s\n", response.getBody());
    }

    @Test
    @Disabled
    void deleteUser() {
        doNothing().when(userService).deleteUser(1);

        ResponseEntity<HttpStatus> response = userController.deleteUser(1);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(userService, times(1)).deleteUser(1);
        System.out.printf("Deleted user: %s\n", response.getStatusCode());
    }
}