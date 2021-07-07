package com.project.ecommercewebsite.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "order_master")
@Data
public class Order_master {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int order_id;

    @Column(name = "order_date")
    private Date order_date;

    @Column(name = "close_order_date")
    private Date close_order_date;

    @Column(name = "customer_id")
    private int customer_id;

    @ManyToMany
    @JoinTable(name = "order_detail", joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))

    private List<Product> products = new ArrayList<>();

}
