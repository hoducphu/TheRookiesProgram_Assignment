package com.project.ecommercewebsite.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "product_price")
@Data
public class Product_price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productprice_id")
    private int productprice_id;

    @Column(name = "update_date", nullable = false)
    private Date update_date;

    @Column(name = "price", nullable = false)
    private int price;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

}
