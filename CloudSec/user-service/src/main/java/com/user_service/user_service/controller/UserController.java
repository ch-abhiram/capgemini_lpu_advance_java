package com.user_service.user_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user_service.user_service.entity.UserInformation;
import com.user_service.user_service.service.UserService;

@RestController
public class UserController {
	
	
	private UserService service;

	public UserController(UserService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/create")
	public String create(@RequestBody UserInformation info) {
		return service.createUser(info);
	}
	
	@GetMapping("/{email}")
	public UserInformation findById(@PathVariable String email) {
		return service.findUser(email);
	}
	
	
	

}
