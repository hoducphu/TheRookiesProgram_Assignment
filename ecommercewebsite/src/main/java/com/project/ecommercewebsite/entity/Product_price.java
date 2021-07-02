package com.project.ecommercewebsite.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "order_master")
@Data
public class Product_price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productprice_id")
    private int productprice_id;

    @Column(name = "update_date")
    private Date update_date;

    @Column(name = "price")
    private int price;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private int product_id;

}
