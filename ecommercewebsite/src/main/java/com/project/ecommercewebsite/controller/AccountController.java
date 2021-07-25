package com.project.ecommercewebsite.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.project.ecommercewebsite.dto.AccountDto;
import com.project.ecommercewebsite.dto.ChangePasswordDto;
import com.project.ecommercewebsite.entity.Account;
import com.project.ecommercewebsite.paypoad.request.LoginRequest;
import com.project.ecommercewebsite.service.IAccountService;

@RestController
@RequestMapping("/api")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    // get all account : read
    @GetMapping("/accounts")
    public List<AccountDto> getAllAccount() {
        return accountService.getAllAccount();
    }

    // get account by its id : read
    @GetMapping("/accounts/{account_id}")
    public ResponseEntity<AccountDto> getAccount(@PathVariable int account_id) {
        AccountDto account = accountService.getAccountById(account_id);
        return ResponseEntity.ok().body(account);
    }

    // create new account : create
    @PostMapping(value = "/auth/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok().body(accountService.login(loginRequest));
    }

    @PostMapping(value = "/auth/register")
    public ResponseEntity<AccountDto> registerUser(@Valid @RequestBody AccountDto accountDto) {
        return ResponseEntity.ok().body(accountService.registerUser(accountDto));
    }

    @PostMapping(value = "/admin/register")
    public ResponseEntity<AccountDto> registerAdmin(@Valid @RequestBody AccountDto accountDto) {
        return ResponseEntity.ok().body(accountService.registerAdmin(accountDto));
    }

    // update account
    @PutMapping(value = "/user/update/{account_id}")
    public ResponseEntity<AccountDto> updateAccount(@PathVariable("account_id") int account_id,
            @RequestBody AccountDto account) {
        AccountDto updatedAccount = accountService.updateAccount(account_id, account);
        return ResponseEntity.ok().body(updatedAccount);
    }

    @PatchMapping(value = "/user/changepassword")
    public ResponseEntity<String> changePassword(@Valid @RequestBody ChangePasswordDto dto,
            @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok().body(accountService.changePassword(dto, token));
    }

    // delete account
    @DeleteMapping(value = "/user/delete/{account_id}")
    public ResponseEntity<Account> deleteAccount(@PathVariable int account_id) {
        accountService.deleteAccount(account_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
