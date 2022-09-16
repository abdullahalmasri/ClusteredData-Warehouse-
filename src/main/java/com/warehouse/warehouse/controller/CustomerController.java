package com.warehouse.warehouse.controller;

import com.warehouse.warehouse.model.Customer;
import com.warehouse.warehouse.service.AccumulativeDealService;
import com.warehouse.warehouse.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "api/v1")
public class CustomerController {
    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

    private final CustomerService customerService;
    private final AccumulativeDealService accumulativeDealService;



    @Autowired
    public CustomerController(CustomerService customerService, AccumulativeDealService accumulativeDealService){
        this.customerService=customerService;
        this.accumulativeDealService = accumulativeDealService;
    }
    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public Customer create(@RequestBody Customer user) throws Exception {
        try {
            customerService.saveCustomer(user);
            log.info("The new user is created {}",user.getCustomerName());
        }catch (Exception e){
            log.warn(String.valueOf(e));
        }
        return user;

    }
    @RequestMapping(value="/customers",method = RequestMethod.GET)
    public List<Customer> getusers(){
        accumulativeDealService.findAllDealsCurrencyCountMap();
//        accumulativeDealService.updateCountOfDealsPerCurrency();
        log.info("the customers in database {}",customerService.findCustomer().size());
        return customerService.findCustomer();
    }
}
