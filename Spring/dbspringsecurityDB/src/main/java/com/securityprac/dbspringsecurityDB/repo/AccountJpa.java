package com.securityprac.dbspringsecurityDB.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.securityprac.dbspringsecurityDB.Entity.Account;

public interface AccountJpa extends JpaRepository<Account, Long>{
	public Optional<Account> findByUsername(String name);
	
	public boolean existsByUsername(String name);
	
	public boolean existsByEmail(String email);
}
