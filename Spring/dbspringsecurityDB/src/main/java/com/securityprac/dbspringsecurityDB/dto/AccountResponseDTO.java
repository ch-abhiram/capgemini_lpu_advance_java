package com.securityprac.dbspringsecurityDB.dto;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class AccountResponseDTO {
	private String username;
	private String email;
	private String phone;
	private String fullname;
	private LocalDateTime createDateTime = LocalDateTime.now();
}
