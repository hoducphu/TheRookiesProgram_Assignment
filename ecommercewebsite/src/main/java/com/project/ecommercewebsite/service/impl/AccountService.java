package com.project.ecommercewebsite.service.impl;

import java.util.List;
import java.util.Optional;

import com.project.ecommercewebsite.dto.AccountDto;
import com.project.ecommercewebsite.dto.ChangePasswordDto;
import com.project.ecommercewebsite.entity.Account;
import com.project.ecommercewebsite.entity.Customer;
import com.project.ecommercewebsite.entity.Role;
import com.project.ecommercewebsite.enums.RoleName;
import com.project.ecommercewebsite.paypoad.request.LoginRequest;
import com.project.ecommercewebsite.repository.AccountRepository;
import com.project.ecommercewebsite.repository.CustomerRepository;
import com.project.ecommercewebsite.repository.RoleRepository;
import com.project.ecommercewebsite.security.jwt.JwtUtils;
import com.project.ecommercewebsite.service.IAccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService implements IAccountService {
    final private AuthenticationManager authenticationManager;

    final private PasswordEncoder encoder;

    final private JwtUtils jwtUtils;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RoleRepository roleRepository;

    public AccountService(AuthenticationManager authenticationManager, PasswordEncoder encoder, JwtUtils jwtUtils,
            AccountRepository accountRepository, CustomerRepository customerRepository, RoleRepository roleRepository) {
        this.authenticationManager = authenticationManager;
        this.encoder = encoder;
        this.jwtUtils = jwtUtils;
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
        this.roleRepository = roleRepository;
    }

    // private String getAccountFromToken(String token) {
    // return
    // Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    // }

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
    public String login(LoginRequest loginRequest) {
        accountRepository.existsByUsername(loginRequest.getUsername());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getUserpassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return jwtUtils.generateJwtToken(authentication);
    }

    @Transactional
    @Override
    public AccountDto registerUser(AccountDto accountDto) throws ResourceNotFoundException {
        if (accountRepository.existsByEmail(accountDto.getEmail()))
            throw new ResourceNotFoundException("Can't Use This Email");
        Account account = AccountDto.toEntity(accountDto);
        Customer customer = new Customer();
        String userRole = RoleName.ROLE_USER.name();
        Role role = roleRepository.findByRole(userRole);
        if (role == null) {
            throw new ResourceNotFoundException("Null");
        }
        customer = customerRepository.save(customer);
        account.setCustomer(customer);
        account.setRole(role);
        account.setUserpassword(encoder.encode(accountDto.getUserpassword()));
        return AccountDto.toDto(accountRepository.save(account));
    }

    @Transactional
    @Override
    public AccountDto registerAdmin(AccountDto accountDto) throws ResourceNotFoundException {
        if (accountRepository.existsByEmail(accountDto.getEmail()))
            throw new ResourceNotFoundException("Can't Use This Email");
        Account account = AccountDto.toEntity(accountDto);
        Customer customer = new Customer();
        String userRole = RoleName.ROLE_ADMIN.name();
        Role role = roleRepository.findByRole(userRole);
        customer = customerRepository.save(customer);
        account.setCustomer(customer);
        account.setRole(role);
        account.setUserpassword(encoder.encode(accountDto.getUserpassword()));
        return AccountDto.toDto(accountRepository.save(account));
    }

    @Transactional
    @Override
    public AccountDto updateAccount(int account_id, AccountDto accountDetails) throws ResourceNotFoundException {
        if (!accountRepository.existsById(accountDetails.getAccount_id())) {
            throw new ResourceNotFoundException("Account not found");
        }
        Optional<Account> _account = accountRepository.updateAccount(accountDetails.getUser_first_name(),
                accountDetails.getUser_last_name(), accountDetails.getUser_phonenumber(), accountDetails.getEmail());
        return AccountDto.toDto(_account.get());
    }

    @Transactional
    @Override
    public String deleteAccount(int account_id) throws ResourceNotFoundException {
        Account account = accountRepository.findById(account_id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found for this id :: " + account_id));
        accountRepository.delete(account);
        return "Account has been deleted";
    }

    @Transactional
    @Override
    public String changePassword(ChangePasswordDto dto, String token) {
        token = token.substring(7);
        // get username from token
        String username = "";
        accountRepository.changePassword(dto.getUserpassword(), username);
        return "success";
    }

}