package com.project.ecommercewebsite.service;

import java.util.List;

import com.project.ecommercewebsite.entity.Customer;

public interface ICustomerService {

    List<Customer> getAllCustomer();

    Customer getCustomerById(int customer_id);

    Customer postCustomer(Customer customer);

    Customer updateCustomer(int customer_id, Customer customer);

    String deleteCustomer(int customer_id);
}
