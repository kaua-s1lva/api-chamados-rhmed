package com.example.ticket_rhmed.controllers;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ticket_rhmed.dto.auth.LoginRequestDTO;
import com.example.ticket_rhmed.dto.auth.RegisterRequestDTO;
import com.example.ticket_rhmed.dto.auth.ResponseDTO;
import com.example.ticket_rhmed.infra.security.TokenService;
import com.example.ticket_rhmed.models.User;
import com.example.ticket_rhmed.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserRepository respository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body) {
        User user = respository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if (passwordEncoder.matches(body.password(), user.getPassword())) {
            String token = tokenService.generateToken(user);
            return ResponseEntity.ok(new ResponseDTO(user.getName(), token));
        } else {
            return ResponseEntity.badRequest().build();
        }

    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO body) {
        Optional<User> user = respository.findByEmail(body.email());

        if (user.isEmpty()) {
            User newUser = new User(
                body.name(), 
                body.email(), 
                passwordEncoder.encode(body.password()), 
                body.role()
            );
            respository.save(newUser);

            String token = tokenService.generateToken(newUser);
            return ResponseEntity.ok(new ResponseDTO(newUser.getName(), token));
        } else {
            return ResponseEntity.badRequest().build();
            //return ResponseEntity.status(409).body("User with this email already exists.");
        }
    }
}
