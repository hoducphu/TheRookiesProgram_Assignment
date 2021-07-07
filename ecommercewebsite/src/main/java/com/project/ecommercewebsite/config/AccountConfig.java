// package com.project.ecommercewebsite.config;

// import java.util.List;

// import com.project.ecommercewebsite.entity.Account;
// import com.project.ecommercewebsite.repository.AccountRepository;

// import org.springframework.boot.CommandLineRunner;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// public class AccountConfig {

// @Bean
// CommandLineRunner commandLineRunner(AccountRepository accountRepository) {
// return x -> {
// Account hoducphu = new Account("phuho", "phuho123", "hoduc", "phu", 11111111,
// "phuho@gmail.com",
// "customer");

// Account phuducho = new Account("phuho123", "phuho234", "hoduc1", "phu2",
// 11111112, "phuho21@gmail.com",
// "customer");

// accountRepository.saveAll(List.of(hoducphu, phuducho));
// };
// }
// }