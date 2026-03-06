package com.securityprac.dbspringsecurityDB.Security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.securityprac.dbspringsecurityDB.Entity.Account;
import com.securityprac.dbspringsecurityDB.repo.AccountJpa;
@Service
public class DbDetailsUserService implements UserDetailsService{
	
	private AccountJpa jpa;
	
	
	public DbDetailsUserService(AccountJpa jpa) {
		this.jpa = jpa;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = jpa.findByUsername(username).orElseThrow(()->new RuntimeException("Username not found"));
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(account.getRole()));
		return new User(account.getUsername(), account.getPassword(), authorities);
	}

}
