package com.project.ecommercewebsite.repository;

import com.project.ecommercewebsite.entity.Product_price;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPriceRepository extends JpaRepository<Product_price, Integer> {
}
