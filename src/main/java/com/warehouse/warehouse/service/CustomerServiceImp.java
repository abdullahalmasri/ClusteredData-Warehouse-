package com.warehouse.warehouse.service;

import com.warehouse.warehouse.Repostory.CustomerRepo;
import com.warehouse.warehouse.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService{
    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerServiceImp(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        customer.setCustomerName(customer.getCustomerName());
        customer.setUserName(customer.getUserName());
        customer.setPassword(customer.getPassword());
        customer.setValidDeal(customer.getValidDeal());
        return customerRepo.save(customer);
    }

    public List<Customer> findCustomer() {
        return customerRepo.findAll();
    }
}
