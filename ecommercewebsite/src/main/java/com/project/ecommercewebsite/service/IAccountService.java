package com.project.ecommercewebsite.service;

import java.util.List;

import com.project.ecommercewebsite.dto.AccountDto;

public interface IAccountService {

    List<AccountDto> getAllAccount();

    AccountDto getAccountById(int account_id);

    AccountDto postAccount(AccountDto accountDto);

    AccountDto updateAccount(int account_id, AccountDto accountDto);

    String deleteAccount(int account_id);
}
