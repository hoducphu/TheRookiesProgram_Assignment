package com.project.ecommercewebsite.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.ecommercewebsite.entity.Customer;
import com.project.ecommercewebsite.service.ICustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    // get all customer : read
    @GetMapping("")
    public List<Customer> getAllCustomer() {
        List<Customer> customers = customerService.getAllCustomer();
        return customers;
    }

    // get customer by its id : read
    @GetMapping("/{customer_id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable int customer_id) {
        Customer customer = customerService.getCustomerById(customer_id);
        return ResponseEntity.ok().body(customer);
    }

    // create new customer : create
    @PostMapping("")
    public Customer createCustomer(@Valid @RequestBody Customer customer) {
        customerService.postCustomer(customer);
        return customer;
    }

    // update customer
    @PutMapping(value = "/{customer_id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("customer_id") int customer_id,
            @RequestBody Customer customer) {
        Customer updatedCustomer = customerService.updateCustomer(customer_id, customer);
        return ResponseEntity.ok().body(updatedCustomer);
    }

    // delete customer
    @DeleteMapping(value = "/{customer_id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable int customer_id) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
