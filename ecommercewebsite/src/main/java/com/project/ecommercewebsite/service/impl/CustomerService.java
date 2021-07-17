package com.project.ecommercewebsite.service.impl;

import java.util.List;

import com.project.ecommercewebsite.entity.Customer;
import com.project.ecommercewebsite.repository.CustomerRepository;
import com.project.ecommercewebsite.service.ICustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // @Autowired
    // private ModelMapper modelMapper;

    @Override
    public List<Customer> getAllCustomer() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(int customer_id) throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(customer_id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customer_id));
        return customer;
    }

    @Override
    public Customer postCustomer(Customer customer) {
        customer.setCustomer_id(0);
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(int customer_id, Customer customerDetails) throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(customer_id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customer_id));

        customer.setReceiver_first_name(customerDetails.getReceiver_first_name());
        customer.setReceiver_last_name(customerDetails.getReceiver_last_name());
        customer.setReceiver_phonenumber(customerDetails.getReceiver_phonenumber());
        customer.setAddress(customerDetails.getAddress());
        Customer updatedCustomer = customerRepository.save(customer);
        return updatedCustomer;
    }

    @Override
    public String deleteCustomer(int customer_id) throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(customer_id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customer_id));
        customerRepository.delete(customer);
        return "Customer has been deleted";
    }
}