package com.jwt.studentjwt.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/profile")
    public String profile() {
        return "This is protected profile";
    }

    @DeleteMapping("/{id}")
    public String delete() {
        return "Student deleted";
    }
}