package com.user_service.user_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "amazon_user_info")
public class UserInformation {

	@Id
	private String emailId;
	private String password;
	private String fullName;

	public UserInformation() {

	}

	public UserInformation(String emailId, String password, String fullName) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.fullName = fullName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String toString() {
		return "UserInformation [emailId=" + emailId + ", password=" + password + ", fullName=" + fullName + "]";
	}

}
