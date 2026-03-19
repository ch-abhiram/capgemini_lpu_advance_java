package com.prac.jwt_prac.service;

import org.springframework.stereotype.Service;

import com.prac.jwt_prac.UserInformationDTO;
import com.prac.jwt_prac.entity.UserInformation;
import com.prac.jwt_prac.repo.UserJpaRepository;

@Service
public class UserService {
	
	private UserJpaRepository userjpa;
	
	public UserService(UserJpaRepository userjpa) {
		this.userjpa=userjpa;
	}
	public UserInformation createUser(UserInformationDTO dto) {
		UserInformation info=new UserInformation();
		info.setEmailId(dto.getEmailId());
		info.setName(dto.getName());
		info.setPassword(dto.getPassword());
		info.setPhone(dto.getPhone());
		return userjpa.save(info);
	}

}
