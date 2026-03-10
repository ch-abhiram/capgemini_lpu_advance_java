package com.course_service.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course_service.client.StudentClient;

@RestController
public class CourseController {

    @Autowired
    private StudentClient studentClient;

    @GetMapping("/course")
    public String getCourse() {

        String student = studentClient.getStudent();

        return "Course Service calling -> " + student;
    }
}