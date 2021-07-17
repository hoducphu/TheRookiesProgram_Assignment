package com.project.ecommercewebsite.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.project.ecommercewebsite.entity.Account;

import lombok.Data;

@Data
public class AccountDto {
    private int account_id;

    private String username;

    private String user_first_name;

    private String user_last_name;

    private String user_phonenumber;

    private String email;

    private String account_role;

    public static AccountDto toDto(Account account) {
        AccountDto accountDto = new AccountDto();
        accountDto.setAccount_id(account.getAccount_id());
        accountDto.setUsername(account.getUsername());
        accountDto.setUser_first_name(account.getUser_first_name());
        accountDto.setUser_last_name(account.getUser_last_name());
        accountDto.setUser_phonenumber(account.getUser_phonenumber());
        accountDto.setEmail(account.getEmail());
        accountDto.setAccount_role(account.getAccount_role());
        return accountDto;
    }

    public static List<AccountDto> toDto(List<Account> accounts) {
        return accounts.stream().map(x -> toDto(x)).collect(Collectors.toList());
    }

    public static Account toEntity(AccountDto accountDto) {
        Account account = new Account();
        account.setAccount_id(accountDto.getAccount_id());
        account.setUsername(accountDto.getUsername());
        account.setUser_first_name(accountDto.getUser_first_name());
        account.setUser_last_name(accountDto.getUser_last_name());
        account.setUser_phonenumber(accountDto.getUser_phonenumber());
        account.setEmail(accountDto.getEmail());
        account.setAccount_role(accountDto.getAccount_role());
        return account;
    }

    public static List<Account> toEntity(List<AccountDto> accountDto) {
        return accountDto.stream().map(x -> toEntity(x)).collect(Collectors.toList());
    }
}