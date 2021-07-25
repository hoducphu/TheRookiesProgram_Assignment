package com.project.ecommercewebsite.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "customer")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customer_id;

    @Column(name = "receiver_first_name", nullable = false)
    private String receiver_first_name = "";

    @Column(name = "receiver_last_name", nullable = false)
    private String receiver_last_name = "";

    @Column(name = "receiver_phonenumber", nullable = false)
    private String receiver_phonenumber = "";

    @Column(name = "address", nullable = false)
    private String address = "";

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Order_master> order_masters;

}
