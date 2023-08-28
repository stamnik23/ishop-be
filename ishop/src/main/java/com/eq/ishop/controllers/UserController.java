package com.eq.ishop.controllers;

import com.eq.ishop.dto.UserProfile;
import com.eq.ishop.dto.UserRegistrationRequest;
import com.eq.ishop.model.ApiResponse;
import com.eq.ishop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserRegistrationRequest registrationRequest) {
        userService.registerUser(registrationRequest);
        return ResponseEntity.ok(new ApiResponse("User registered successfully"));
    }

    @GetMapping("/profile")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getUserProfile(Authentication authentication) {
        UserProfile userProfile = userService.getUserProfile(authentication.getName());
        return ResponseEntity.ok(userProfile);
    }
}