package com.application.task_manager.services;

import com.application.task_manager.models.User;
import com.application.task_manager.models.UserPrincipal;
import com.application.task_manager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public MyUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElse(null);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        return new UserPrincipal(user);
    }
}
