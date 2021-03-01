package com.FullStack.auth.service;


import com.FullStack.user.model.User;
import com.FullStack.user.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service // Instruct Spring Boot that this is the Service layer
public class UserDetailsServiceImpl implements UserDetailsService {

    // Import Methods from other Class
    public final UserRepository userRepository; // Call UserService method(s)

    // Make methods accessible via this constructor
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override // Override functions/methods
    @Transactional // Execute transaction methods without stating them
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { // Call function loadUserByUsername
        User user = userRepository.getUserByUsername(username) // Execute method getUserByUsername from UserRepository.java
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username)); // User not found exception handling

        return UserDetailsImpl.build(user); // Return user
    }
}

