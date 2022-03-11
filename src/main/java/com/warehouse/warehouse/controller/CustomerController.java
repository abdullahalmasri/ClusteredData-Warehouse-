package com.warehouse.warehouse.controller;

import com.warehouse.warehouse.model.CurrencyCode;
import com.warehouse.warehouse.model.Customer;
import com.warehouse.warehouse.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class CustomerController {
    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

    private final CustomerService customerService;


    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService=customerService;
    }
    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public Customer create(@RequestBody Customer user) {
        customerService.saveCustomer(user);
        log.info("The new user is created {}",user.getCustomerName());
        return user;
    }
    @RequestMapping(value="/customers",method = RequestMethod.GET)
    public List<Customer> getusers(){
        log.info("the customers in database...");
        return customerService.findCustomer();
    }
}
