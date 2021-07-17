package com.project.ecommercewebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ecommercewebsite.entity.Order_detail;

@Repository
public interface OrderDetailRepository extends JpaRepository<Order_detail, Integer> {

}
