package com.project.ecommercewebsite.controller;

import java.util.List;

import com.project.ecommercewebsite.entity.Account;
import com.project.ecommercewebsite.service.impl.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("")
    List<Account> all() {
        return null;
    }

    @PostMapping("")
    public ResponseEntity<?> createAccount() {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAccount() {
        return null;
    }
}
