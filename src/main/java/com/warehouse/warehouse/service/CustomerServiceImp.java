package com.warehouse.warehouse.service;

import com.warehouse.warehouse.Repostory.CustomerRepo;
import com.warehouse.warehouse.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerServiceImp implements CustomerService{
    private final CustomerRepo customerRepo;
    private static final Logger log = LoggerFactory.getLogger(CustomerServiceImp.class);

    @Autowired
    public CustomerServiceImp(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public Customer saveCustomer(Customer customer) throws Exception {
        List<Customer> customerList =findCustomer();
        for (Customer customer1:customerList){
          if (customer1.getUserName().equals(customer.getUserName())){
              log.warn("The user with Username {} already exists",customer.getUserName());
              throw new Exception ("the user with username is exists in our Database");
          } else {
              customer.setCustomerName(customer.getCustomerName());
              customer.setUserName(customer.getUserName());
              customer.setPassword(customer.getPassword());
              customer.setValidDeal(customer.getValidDeal());

          }
        }
        return customerRepo.save(customer);
    }

    public List<Customer> findCustomer() { return customerRepo.findAll(); }


}
