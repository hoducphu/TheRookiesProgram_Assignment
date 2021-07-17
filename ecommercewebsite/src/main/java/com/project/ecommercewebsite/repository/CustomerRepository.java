package com.project.ecommercewebsite.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.ecommercewebsite.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    // @Query(value = "UPDATE public.customer SET
    // receiver_first_name=':receiver_first_name',
    // receiver_last_name=':receiver_last_name',
    // receiver_phonenumber=':receiver_phonenumber', address=':address' WHERE
    // customer_id=customer_id returning *", nativeQuery = true)
    // Optional<Customer> updateCustomer(@Param("receiver_first_name") String
    // receiver_first_name,
    // @Param("receiver_last_name") String receiver_last_name,
    // @Param("receiver_phonenumber") String receiver_phonenumber, @Param("address")
    // String address);
}
