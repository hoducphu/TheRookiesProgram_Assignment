package com.project.ecommercewebsite.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Account")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private int account_id;

    @Column(name = "username")
    private String username;

    @Column(name = "userpassword")
    private String userpassword;

    @Column(name = "user_first_name")
    private String user_first_name;

    @Column(name = "user_last_name")
    private String user_last_name;

    @Column(name = "user_phonenumber", nullable = false)
    private int user_phonenumber;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "account_role")
    private String account_role;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Collection<Customer> customers;
}
