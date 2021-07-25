package com.project.ecommercewebsite.service.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.ecommercewebsite.entity.Account;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    private int account_id;

    private String username;

    @JsonIgnore
    private String userpassword;

    private String user_first_name;

    private String user_last_name;

    private String user_phonenumber;

    private String email;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(int account_id, String username, String userpassword, String user_first_name,
            String user_last_name, String user_phonenumber, String email,
            Collection<? extends GrantedAuthority> authorities) {
        super();
        this.account_id = account_id;
        this.username = username;
        this.userpassword = userpassword;
        this.user_first_name = user_first_name;
        this.user_last_name = user_last_name;
        this.user_phonenumber = user_phonenumber;
        this.email = email;
        this.authorities = authorities;

    }

    public static UserDetailsImpl build(Account account) {
        List<GrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(account.getRole().getRole()));

        return new UserDetailsImpl(account.getAccount_id(), account.getUsername(), account.getUserpassword(),
                account.getUser_first_name(), account.getUser_last_name(), account.getUser_phonenumber(),
                account.getEmail(), authorities);
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return userpassword;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
