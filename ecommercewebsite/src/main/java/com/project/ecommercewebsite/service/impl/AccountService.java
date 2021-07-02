package com.project.ecommercewebsite.service.impl;

import com.project.ecommercewebsite.repository.AccountRepository;
import com.project.ecommercewebsite.service.IAccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountService implements IAccountService {
    @Autowired
    private AccountRepository accountRepository;
}
