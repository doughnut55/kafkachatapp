package com.example.demo.UserStuff;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.UserStuff.User;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        // You can perform validation and other checks here
        // For simplicity, let's assume no validation for now
        return userRepository.save(user);
    }

    // You can add more endpoints for user management (e.g., get user by ID, update user, delete user, etc.)
}
