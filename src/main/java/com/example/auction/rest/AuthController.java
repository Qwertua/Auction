package com.example.auction.rest;

import com.example.auction.models.Users;
import com.example.auction.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AuthController {
    private final UserRepository userRepository;

    @Autowired
    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Users user) {
        Users existingUser = userRepository.findByName(user.getName());
        if (existingUser != null) {
            return ResponseEntity.badRequest().body("User already exists");
        }
        userRepository.save(user);
        return ResponseEntity.ok("User registered");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String name, @RequestParam String password) {
        Users existingUser = userRepository.findByName(name);
        if (existingUser == null || !existingUser.getPassword().equals(password)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
        return ResponseEntity.ok(existingUser);
    }
}
