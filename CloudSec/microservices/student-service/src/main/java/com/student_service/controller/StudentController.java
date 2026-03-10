package com.student_service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class StudentController {

    @Value("${message}")
    private String message;

    @GetMapping("/student")
    public String getStudent() {
        return "Student Service -> " + message;
    }
}
