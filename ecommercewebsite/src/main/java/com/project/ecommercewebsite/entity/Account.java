package com.project.ecommercewebsite.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Account")
@Data
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long account_id;

    @Column(name = "username")
    private String username;

    @Column(name = "userpassword")
    private String userpassword;

    @Column(name = "user_first_name")
    private String user_first_name;

    @Column(name = "user_last_name")
    private String user_last_name;

    @Column(name = "user_phonenumber")
    private int user_phonenumber;

    @Column(name = "email")
    private String email;

    @Column(name = "account_role")
    private String account_role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private int customer_id;

    public Account(String username, String userpassword, String user_first_name, String user_last_name,
            int user_phonenumber, String email, String account_role) {
        this.username = username;
        this.userpassword = userpassword;
        this.user_first_name = user_first_name;
        this.user_last_name = user_last_name;
        this.user_phonenumber = user_phonenumber;
        this.email = email;
        this.account_role = account_role;
    }
}
