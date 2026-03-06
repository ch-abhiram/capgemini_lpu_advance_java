package com.securityprac.dbspringsecurityDB.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.securityprac.dbspringsecurityDB.dto.AccountRequestDTO;
import com.securityprac.dbspringsecurityDB.dto.AccountResponseDTO;
import com.securityprac.dbspringsecurityDB.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    // CREATE USER
    @PostMapping("/create")
    public AccountResponseDTO create(@RequestBody AccountRequestDTO dto) {
        return service.createAccount(dto);
    }

    // FIND BY ID
    @GetMapping("/{id}")
    public AccountResponseDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    // FIND ALL
    @GetMapping
    public List<AccountResponseDTO> findAll() {
        return service.findAll();
    }

    // ADMIN ONLY ENDPOINT
    @GetMapping("/admin")
    public String adminOnly() {
        return "Welcome Admin";
    }
    
    @GetMapping("/admin/users")
    public List<AccountResponseDTO> getAllUsersForAdmin() {
        return service.getAllUsersForAdmin();
    }
}
	
