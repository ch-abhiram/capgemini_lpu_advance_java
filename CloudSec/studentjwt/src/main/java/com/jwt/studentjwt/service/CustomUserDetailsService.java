package com.jwt.studentjwt.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.jwt.studentjwt.entity.Student;
import com.jwt.studentjwt.repository.StudentRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private StudentRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) {
        Student student = repo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return new User(student.getEmail(), student.getPassword(), new ArrayList<>());
    }
}