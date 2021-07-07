package com.project.ecommercewebsite.service.impl;

import java.util.HashSet;
import java.util.Set;

import com.project.ecommercewebsite.entity.Account;
import com.project.ecommercewebsite.repository.AccountRepository;
import com.project.ecommercewebsite.service.IAccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Set<Account> getAccount() {
        Set<Account> accounts = new HashSet<>();
        accountRepository.findAll().forEach(accounts::add);
        return accounts;
    }

    @Override
    public Account getAccountById(Long account_id) {
        return accountRepository.findById(account_id).get();
    }

    @Override
    public Account postAccount(Account account) {
        return accountRepository.save(account);
    }

    // @Override
    // public void updateAccount(int account_id, Account account) {
    // // TODO Auto-generated method stub

    // }

    // @Override
    // public void deleteAccount(int account_id) {
    // // TODO Auto-generated method stub

    // }

    // @Override
    // public void updateAccount(int account_id, Account account) {
    // Account accountFromDB = accountRepository.findById(account_id).get();
    // System.out.println(accountFromDB.toString());
    // accountFromDB.setUsername(account.getUsername());
    // accountFromDB.setUserpassword(account.getUserpassword());
    // accountFromDB.setUser_first_name(account.getUser_first_name());
    // accountFromDB.setUser_last_name(account.getUser_last_name());
    // accountFromDB.setUser_phonenumber(account.getUser_phonenumber());
    // accountFromDB.setEmail(account.getEmail());
    // accountFromDB.setAccount_role(account.getAccount_role());
    // accountRepository.save(accountFromDB);
    // }

    // @Override
    // public Account deleteAccount(int account_id) {
    // Account _account = new accountRepository.deleteAccount(account_id);
    // return _account;
    // }
}
