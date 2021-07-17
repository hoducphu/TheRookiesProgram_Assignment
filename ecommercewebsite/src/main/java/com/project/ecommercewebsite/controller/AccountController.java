package com.project.ecommercewebsite.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.ecommercewebsite.dto.AccountDto;
import com.project.ecommercewebsite.entity.Account;
import com.project.ecommercewebsite.service.IAccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    // get all account : read
    @GetMapping("")
    public List<AccountDto> getAllAccount() {
        return accountService.getAllAccount();
    }

    // get account by its id : read
    @GetMapping("/{account_id}")
    public ResponseEntity<AccountDto> getAccount(@PathVariable int account_id) {
        AccountDto account = accountService.getAccountById(account_id);
        return ResponseEntity.ok().body(account);
    }

    // create new account : create
    @PostMapping("")
    public ResponseEntity<AccountDto> createAccount(@Valid @RequestBody AccountDto accountDto) {
        accountService.postAccount(accountDto);
        return ResponseEntity.ok().body(accountDto);
    }

    // update account
    @PutMapping(value = "/{account_id}")
    public ResponseEntity<AccountDto> updateAccount(@PathVariable("account_id") int account_id,
            @RequestBody AccountDto account) {
        AccountDto updatedAccount = accountService.updateAccount(account_id, account);
        return ResponseEntity.ok().body(updatedAccount);
    }

    // delete account
    @DeleteMapping(value = "/{account_id}")
    public ResponseEntity<Account> deleteAccount(@PathVariable int account_id) {
        accountService.deleteAccount(account_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
