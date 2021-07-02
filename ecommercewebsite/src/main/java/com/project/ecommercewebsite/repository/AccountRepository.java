package com.project.ecommercewebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ecommercewebsite.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
