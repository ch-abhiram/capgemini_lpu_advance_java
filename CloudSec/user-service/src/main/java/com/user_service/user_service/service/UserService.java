package com.user_service.user_service.service;

import org.springframework.stereotype.Service;

import com.user_service.user_service.entity.UserInformation;
import com.user_service.user_service.repository.UserJpaRepository;

@Service
public class UserService {
	
	private UserJpaRepository jpa;

	public UserService(UserJpaRepository jpa) {
		
		this.jpa = jpa;
	}
	
	public String createUser(UserInformation info) {
		jpa.save(info);
		return "Data Saved";
	}
	
	
	public UserInformation findUser(String emailId) {
		return jpa.findById(emailId).orElseThrow(()->new RuntimeException("Email not exist"));
	}
	
	

}
