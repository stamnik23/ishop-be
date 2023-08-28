package com.eq.ishop.service;

import com.eq.ishop.dto.UserRegistrationRequest;
import com.eq.ishop.dto.UserProfile;
import com.eq.ishop.exception.EmailAlreadyExistsException;
import com.eq.ishop.exception.UsernameAlreadyExistsException;
import com.eq.ishop.model.User;
import com.eq.ishop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(UserRegistrationRequest registrationRequest) {
        // Validate and process user registration
        if (userRepository.existsByUsername(registrationRequest.getUsername())) {
            throw new UsernameAlreadyExistsException("Username is already taken");
        }

        if (userRepository.existsByEmail(registrationRequest.getEmail())) {
            throw new EmailAlreadyExistsException("Email address is already registered");
        }

        // Create a new user
        User user = new User();
        user.setUsername(registrationRequest.getUsername());
        user.setEmail(registrationRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));

        // Save the user to the database
        return userRepository.save(user);
    }

    public UserProfile getUserProfile(String username) {
        return userRepository.findByUsername(username)
                .map(user -> {
                    UserProfile userProfile = new UserProfile();
                    userProfile.setId(user.getId());
                    userProfile.setUsername(user.getUsername());
                    return userProfile;
                })
                .orElse(null);
    }


}