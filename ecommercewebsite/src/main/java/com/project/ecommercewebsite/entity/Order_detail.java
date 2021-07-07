package com.project.ecommercewebsite.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order_detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderdetail_id")
    private int orderdetail_id;

    @Column(name = "ordinnal_number")
    private int ordinnal_number;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private int price;

    @Column(name = "status")
    private String status;

    @Column(name = "deli_date")
    private Date deli_date;

    @Column(name = "deli_place")
    private String deli_place;

    @OneToMany(mappedBy = "order_detail", cascade = CascadeType.ALL)
    private List<Product> listProduct;

}
