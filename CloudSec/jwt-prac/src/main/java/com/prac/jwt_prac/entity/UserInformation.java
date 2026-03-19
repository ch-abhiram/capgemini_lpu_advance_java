package com.prac.jwt_prac.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserInformation {
	@Id
	private String emailId;
	private String name;
	private String password;
	private String phone;

	public UserInformation() {

	}

	public UserInformation(String emailId, String name, String password, String phone) {

		this.emailId = emailId;
		this.name = name;
		this.password = password;
		this.phone = phone;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
