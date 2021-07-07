package com.project.ecommercewebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ecommercewebsite.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
