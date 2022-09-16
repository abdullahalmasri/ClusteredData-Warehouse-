package com.warehouse.warehouse.service;

import com.warehouse.warehouse.model.Customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {
    Customer saveCustomer(Customer customer) throws Exception;
    List<Customer> findCustomer();
}
