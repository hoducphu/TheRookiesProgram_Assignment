package com.project.ecommercewebsite.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "customer")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customer_id;

    @Column(name = "receiver_first_name")
    private String receiver_first_name;

    @Column(name = "receiver_last_name", nullable = false)
    private String receiver_last_name;

    @Column(name = "receiver_phonenumber", nullable = false)
    private int receiver_phonenumber;

    @Column(name = "address", nullable = false)
    private String address;

    @OneToOne
    @JoinColumn(name = "account_id")
    private int account_id;

}
