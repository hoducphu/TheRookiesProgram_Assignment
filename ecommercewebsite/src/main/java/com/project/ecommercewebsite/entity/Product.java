package com.project.ecommercewebsite.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_master")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int product_id;

    @Column(name = "product_name")
    private String product_name;

    @Column(name = "rate")
    private int rate;

    @Column(name = "origin")
    private String origin;

    @Column(name = "color")
    private String color;

    @Column(name = "brand")
    private String brand;

    @Column(name = "meterial")
    private String meterial;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(mappedBy = "order_master", fetch = FetchType.LAZY)
    private List<Order_detail> order_detail = new ArrayList<>();

    @OneToMany(mappedBy = "Product")
    private Set<Product_price> product_prices = new HashSet<>();

}
