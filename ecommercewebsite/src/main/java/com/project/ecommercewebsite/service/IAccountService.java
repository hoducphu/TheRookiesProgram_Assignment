package com.project.ecommercewebsite.service;

import java.util.List;

import com.project.ecommercewebsite.dto.AccountDto;
import com.project.ecommercewebsite.dto.ChangePasswordDto;
import com.project.ecommercewebsite.paypoad.request.LoginRequest;

public interface IAccountService {

    List<AccountDto> getAllAccount();

    AccountDto getAccountById(int account_id);

    String login(LoginRequest loginRequest);

    AccountDto registerUser(AccountDto accountDto);

    AccountDto registerAdmin(AccountDto accountDto);

    String changePassword(ChangePasswordDto dto, String token);

    AccountDto updateAccount(int account_id, AccountDto accountDto);

    String deleteAccount(int account_id);
}
