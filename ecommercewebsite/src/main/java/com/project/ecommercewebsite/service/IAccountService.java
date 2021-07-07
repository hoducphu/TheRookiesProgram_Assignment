package com.project.ecommercewebsite.service;

import java.util.Set;

import com.project.ecommercewebsite.entity.Account;
// import com.project.ecommercewebsite.repository.AccountRepository;

import org.springframework.stereotype.Component;

@Component
public interface IAccountService {

    Set<Account> getAccount();

    Account getAccountById(Long account_id);

    Account postAccount(Account account);

    // void updateAccount(int account_id, Account account);

    // void deleteAccount(int account_id);
}
