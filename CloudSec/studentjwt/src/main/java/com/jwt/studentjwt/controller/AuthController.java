package com.jwt.studentjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.studentjwt.dto.AuthRequest;
import com.jwt.studentjwt.dto.AuthResponse;
import com.jwt.studentjwt.entity.Student;
import com.jwt.studentjwt.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("/register")
    public String register(@RequestBody Student student) {
        service.register(student);
        return "User registered";
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        String token = service.login(request.email, request.password);
        return new AuthResponse(token);
    }
}