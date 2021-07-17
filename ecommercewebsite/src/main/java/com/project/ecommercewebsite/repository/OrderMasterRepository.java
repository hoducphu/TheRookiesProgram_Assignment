package com.project.ecommercewebsite.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.ecommercewebsite.entity.Order_master;

@Repository
public interface OrderMasterRepository extends JpaRepository<Order_master, Integer> {
    // @Query(value = "UPDATE public.order_master SET order_date=':order_date',
    // close_order_date=':close_order_date' WHERE order_id=:order_id returning *",
    // nativeQuery = true)
    // Optional<Order_master> updateOrder(@Param("order_date") String order_date,
    // @Param("close_order_date") String close_order_date);
}
