package com.ajit.alertops.controller;

import com.ajit.alertops.model.AppUser;
import com.ajit.alertops.model.User;
import com.ajit.alertops.repository.UserRepository;
import com.ajit.alertops.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRepository repo;
    private final PasswordEncoder encoder;

    public AuthController(UserRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @PostMapping("/register")
    public String register(@RequestBody AppUser user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
        return "User registered";
    }

    @PostMapping("/login")
    public String login(@RequestBody AppUser user) {

        AppUser dbUser = repo.findByUsername(user.getUsername())
                .orElseThrow();

        if (!encoder.matches(user.getPassword(), dbUser.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return JwtUtil.generateToken(dbUser.getUsername(), dbUser.getRole());
    }

}
