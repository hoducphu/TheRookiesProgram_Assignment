package com.project.ecommercewebsite.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int product_id;

    @Column(name = "product_name", nullable = false)
    private String product_name;

    @Column(name = "rate", nullable = false)
    private float rate;

    @Column(name = "origin", nullable = false)
    private String origin;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "material", nullable = false)
    private String material;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Order_detail> productDetails = new ArrayList<>();

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Product_price> product_prices = new ArrayList<>();

}
