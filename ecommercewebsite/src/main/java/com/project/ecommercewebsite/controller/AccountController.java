package com.project.ecommercewebsite.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.ecommercewebsite.entity.Account;
// import com.project.ecommercewebsite.repository.AccountRepository;
import com.project.ecommercewebsite.service.impl.AccountService;
// import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    // get all account : read
    @GetMapping("")
    public ResponseEntity<Set<Account>> getAllAccount() {
        Set<Account> accounts = accountService.getAccount();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    // get account by its id : read
    @GetMapping("/{account_id}")
    public ResponseEntity<Account> getAccount(@PathVariable Long account_id) {
        return new ResponseEntity<>(accountService.getAccountById(account_id), HttpStatus.OK);
    }

    // create new account : create
    @PostMapping("")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account newAccount = accountService.postAccount(account);
        HttpHeaders headers = new HttpHeaders();
        headers.add("", "/account" + newAccount.getAccount_id());
        return new ResponseEntity<>(newAccount, headers, HttpStatus.CREATED);
    }

    // // update account
    // @PutMapping(value = "/{account_id}")
    // public Account ResponseEntity<Account>
    // updateAccount(@PathVariable("account_id") int account_id,
    // @RequestBody Account account) {
    // accountService.updateAccount(account_id, account);
    // return new ResponseEntity<>(accountService.getAccountById(account_id),
    // HttpStatus.OK);
    // }

    // // delete account
    // @DeleteMapping
    // public Account ResponseEntity<Account> deleteAccount(@PathVariable int
    // account_id) {
    // accountService.deleteAccount(account_id);
    // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // }

}
