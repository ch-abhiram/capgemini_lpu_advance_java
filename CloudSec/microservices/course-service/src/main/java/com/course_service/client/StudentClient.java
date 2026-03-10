package com.course_service.client;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="student-service")
public interface StudentClient {

    @GetMapping("/student")
    String getStudent();
}