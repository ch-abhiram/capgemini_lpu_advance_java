package com.prac.jwt_prac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prac.jwt_prac.UserInformationDTO;
import com.prac.jwt_prac.entity.UserInformation;
import com.prac.jwt_prac.service.UserService;
import com.prac.jwt_prac.util.JwtUtil;

@RestController
public class JwtController {
	
	@Autowired
	JwtUtil util;
	
	@Autowired
	private UserService service;
	
	@GetMapping("/{username}")
	public String user(@PathVariable String username) {
		return util.createToken(username);
	}
	
	@GetMapping("/get-user/{token}")
	public String getUserName(@PathVariable String token) {
		return util.getUserName(token);
	}
	
	
	@GetMapping("/validate/{user}/{token}")
	public boolean isTokenValid(@PathVariable String user,@PathVariable String token) {
		return util.isValidateToken(user, token);
	}
	
	@PostMapping("/create-user")
	public UserInformation createUser(@RequestBody UserInformationDTO dto) {
		return service.createUser(dto);
	}

}
