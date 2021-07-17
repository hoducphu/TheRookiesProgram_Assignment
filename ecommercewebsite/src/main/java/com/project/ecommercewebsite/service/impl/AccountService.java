package com.project.ecommercewebsite.service.impl;

import java.util.List;

import com.project.ecommercewebsite.dto.AccountDto;
import com.project.ecommercewebsite.entity.Account;
import com.project.ecommercewebsite.entity.Customer;
import com.project.ecommercewebsite.repository.AccountRepository;
import com.project.ecommercewebsite.repository.CustomerRepository;
import com.project.ecommercewebsite.service.IAccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<AccountDto> getAllAccount() {
        List<Account> accounts = accountRepository.findAll();
        return AccountDto.toDto(accounts);
    }

    @Override
    public AccountDto getAccountById(int account_id) throws ResourceNotFoundException {
        Account account = accountRepository.findById(account_id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found for this id :: " + account_id));
        return AccountDto.toDto(account);
    }

    @Override
    public AccountDto postAccount(AccountDto accountDto) {
        Account account = AccountDto.toEntity(accountDto);
        Customer customer = new Customer();
        customer = customerRepository.save(customer);
        Account _account = new Account();
        _account.setCustomer(customer);
        accountDto.setAccount_id(0);
        return AccountDto.toDto(accountRepository.save(account));
    }

    @Override
    public AccountDto updateAccount(int account_id, AccountDto accountDetails) throws ResourceNotFoundException {
        Account account = accountRepository.findById(account_id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found for this id :: " + account_id));

        account.setUser_first_name(accountDetails.getUser_first_name());
        account.setUser_last_name(accountDetails.getUser_last_name());
        account.setUser_phonenumber(accountDetails.getUser_phonenumber());
        account.setEmail(accountDetails.getEmail());
        Account updateAccount = accountRepository.save(account);
        return AccountDto.toDto(updateAccount);
    }

    @Override
    public String deleteAccount(int account_id) throws ResourceNotFoundException {
        Account account = accountRepository.findById(account_id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found for this id :: " + account_id));
        accountRepository.delete(account);
        return "Account has been deleted";
    }
}