package com.application.task_manager.services;

import com.application.task_manager.models.User;
import com.application.task_manager.models.UserPrincipal;
import com.application.task_manager.repositories.UserRepository;
import com.application.task_manager.security.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public UserService(UserRepository userRepository, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder(12); // Strength set to 12
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    public User createUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        User newUser = new User();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setRole(user.getRole());
        newUser.setCreateTime(user.getCreateTime());
        return userRepository.save(newUser);
    }

    public User updateUser(int id, User user) {
        User existingUser = findUserById(id);
        if (existingUser != null) {
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmail(user.getEmail());
            if (user.getPassword() != null && !user.getPassword().isEmpty()) {
                existingUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            }
            existingUser.setRole(user.getRole());
            return userRepository.save(existingUser);
        } else {
            return null;
        }
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public String verifyUser(User user) {
        System.out.println("Attempting to authenticate user: " + user.getEmail());

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
        );

        if (authentication.isAuthenticated()) {
            System.out.println("Attempting to authenticate user again: " + user.getEmail() + "Password: " + user.getPassword());

            return jwtService.generateToken(user.getEmail());
        }

        return "Failed to log in";
    }
}