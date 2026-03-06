package com.securitypractice.springsecuritydemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PracticeController {
	@GetMapping("/user")
	public String getDetails() {
		return "Details";
	}
	@GetMapping("/admin")
	public String deleteUser() {
		return "Delete";
	}
	@GetMapping("/hello")
	public String helloUser() {
		return "hello";
	}

}
