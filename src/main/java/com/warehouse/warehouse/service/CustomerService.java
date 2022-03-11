package com.warehouse.warehouse.service;

import com.warehouse.warehouse.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer saveCustomer(Customer customer);
    List<Customer> findCustomer();
}
