package com.project.ecommercewebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ecommercewebsite.entity.Order_master;

@Repository
public interface OrderMasterRepository extends JpaRepository<Order_master, Integer> {

}
