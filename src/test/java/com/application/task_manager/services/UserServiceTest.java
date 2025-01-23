package com.application.task_manager.services;

import com.application.task_manager.models.Role;
import com.application.task_manager.models.User;
import com.application.task_manager.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAllUsers() {
        userService.findAllUsers();
        verify(userRepository, times(1)).findAll();
        System.out.printf("Users: %s\n", userService.findAllUsers());
    }

    @Test
    void findUserById() {
        int userId = 1;
        userService.findUserById(userId);
        verify(userRepository, times(1)).findById(userId);
        System.out.printf("User ID: %s\n", userService.findUserById(userId));
    }

    @Test
    void findUserByEmail() {
        String email = "test@example.com";
        userService.findUserByEmail(email);
        verify(userRepository, times(1)).findByEmail(email);
        System.out.printf("User Email: %s\n", userService.findUserByEmail(email));
    }

    @Test
    void createUser() {
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@example.com");
        user.setPassword("password123");
        user.setRole(Role.USER);

        User savedUser = new User();
        savedUser.setId(1); // Auto-generated ID
        savedUser.setFirstName("John");
        savedUser.setLastName("Doe");
        savedUser.setEmail("john.doe@example.com");
        savedUser.setPassword("password123");
        savedUser.setRole(Role.USER);

        when(userRepository.save(user)).thenReturn(savedUser);

        User result = userService.createUser(user);
        assertNotNull(result);
        assertEquals(1, result.getId());
        verify(userRepository, times(1)).save(user);
        System.out.printf("Created user: %s\n", result);
    }

    @Test
    @Disabled
    void updateUser() {
        int userId = 1;
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@example.com");
        user.setPassword("password123");
        user.setRole(Role.ADMIN);

        User existingUser = new User();
        existingUser.setId(userId);
        existingUser.setFirstName("Jane");
        existingUser.setLastName("Doe");
        existingUser.setEmail("jane.doe@example.com");
        existingUser.setPassword("password123");
        existingUser.setRole(Role.ADMIN);

        when(userRepository.findById(userId)).thenReturn(Optional.of(existingUser));
        when(userRepository.save(existingUser)).thenReturn(existingUser);

        User result = userService.updateUser(userId, user);
        assertNotNull(result);
        assertEquals(userId, result.getId());
        assertEquals("John", result.getFirstName());
        verify(userRepository, times(1)).save(existingUser);
        System.out.printf("Updated user: %s\n", result);
    }

    @Test
    @Disabled
    void deleteUser() {
        int userId = 1;
        userService.deleteUser(userId);
        verify(userRepository, times(1)).deleteById(userId);
        System.out.printf("Deleted user ID: %s\n", userId);
    }

    @Test
    void loadUserByUsername() {
        String email = "test@example.com";
        User user = new User();
        user.setEmail(email);

        when(userRepository.findByEmail(email)).thenReturn(Optional.of(user));
        assertNotNull(userService.loadUserByUsername(email));
        System.out.printf("Loaded user: %s\n", userService.loadUserByUsername(email));
    }

    @Test
    void loadUserByUsername_UserNotFound() {
        String email = "notfound@example.com";
        when(userRepository.findByEmail(email)).thenReturn(Optional.empty());
        assertThrows(UsernameNotFoundException.class, () -> userService.loadUserByUsername(email));
        System.out.printf("User not found: %s\n", email);
    }
}