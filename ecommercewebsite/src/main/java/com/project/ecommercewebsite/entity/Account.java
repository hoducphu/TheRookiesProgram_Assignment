package com.project.ecommercewebsite.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Table(name = "account", uniqueConstraints = { @UniqueConstraint(columnNames = { "customer_id" }) })
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private int account_id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "userpassword", nullable = false)
    private String userpassword;

    @Column(name = "user_first_name", nullable = false)
    private String user_first_name;

    @Column(name = "user_last_name", nullable = false)
    private String user_last_name;

    @Column(name = "user_phonenumber", nullable = false)
    private String user_phonenumber;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "account_role", nullable = false)
    private String account_role;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", unique = true)
    private Customer customer;
}