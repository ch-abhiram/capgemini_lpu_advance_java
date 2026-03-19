package com.jwt.studentjwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jwt.studentjwt.entity.Student;
import com.jwt.studentjwt.repository.StudentRepository;

@Service
public class AuthService {

    @Autowired
    private StudentRepository repo;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtService jwtService;

    public void register(Student student) {
        student.setPassword(encoder.encode(student.getPassword()));
        repo.save(student);
    }

    public String login(String email, String password) {
        Student student = repo.findByEmail(email)
                .orElseThrow();

        if (encoder.matches(password, student.getPassword())) {
            return jwtService.generateToken(email);
        }

        throw new RuntimeException("Invalid credentials");
    }
}
