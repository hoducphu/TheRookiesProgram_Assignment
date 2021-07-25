package com.project.ecommercewebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ecommercewebsite.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
