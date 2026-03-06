package com.securityprac.dbspringsecurityDB.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.securityprac.dbspringsecurityDB.Entity.Account;
import com.securityprac.dbspringsecurityDB.dto.AccountRequestDTO;
import com.securityprac.dbspringsecurityDB.dto.AccountResponseDTO;
import com.securityprac.dbspringsecurityDB.repo.AccountJpa;
@Service
public class AccountService {
	
	private AccountJpa jpa;
	
	private PasswordEncoder encode;

	public AccountService(AccountJpa jpa, PasswordEncoder encode) {
		
		this.jpa = jpa;
		this.encode = encode;
	}
	
	public AccountResponseDTO createAccount(AccountRequestDTO dto) {
		if(jpa.existsByUsername(dto.getUsername())) {
			throw new RuntimeException("User Name Exist");
		}if(jpa.existsByEmail(dto.getEmail())) {
			throw new RuntimeException("User Email exist");
		}
		
		Account account = new Account();
		
		account.setUsername(dto.getUsername());
		account.setFullname(dto.getFullname());
		account.setPassword(encode.encode(dto.getPassword()));
		account.setPhone(dto.getPhone());
		account.setCreateDateTime(dto.getCreateDateTime());
		account.setEmail(dto.getEmail());
		account.setRole(dto.getRole());
		jpa.save(account);
		return toResponse(account);
	}
	
	public String normalizeAndValidateRole(String role) {
		if(role==null || role.trim().isEmpty()) {
			return "ROLE_User";
		}
		
		String r = role.trim().toUpperCase();
		if(!r.startsWith("ROLE_")) {
			r = "ROLE_"+r;
		}
		if(!(role.equalsIgnoreCase("ROLE_USER") || role.equalsIgnoreCase("ROLE_ADMIN"))) {
			throw new RuntimeException("Invalid role");
		}
		return r;
	}
	
	public AccountResponseDTO toResponse(Account a) {
		AccountResponseDTO dto = new AccountResponseDTO();
		
		dto.setEmail(a.getEmail());
		dto.setFullname(a.getFullname());
		dto.setCreateDateTime(a.getCreateDateTime());
		dto.setPhone(a.getPhone());
		dto.setUsername(a.getUsername());
		return dto;
	}
	
	public AccountResponseDTO getById(Long id) {
		Account a = jpa.findById(id).orElseThrow(()-> new RuntimeException("Id not found"));
		
		return toResponse(a);
	}
	
	public AccountResponseDTO findById(Long id) {

        Account account = jpa.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        return toResponse(account);
    }

    
    public List<AccountResponseDTO> findAll() {

        List<Account> accounts = jpa.findAll();

        return accounts.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
	
    public List<AccountResponseDTO> getAllUsersForAdmin() {

        List<Account> accounts = jpa.findAll();

        return accounts.stream()
                .map(this::toResponse)
                .toList();
    }
	
	
	

}
