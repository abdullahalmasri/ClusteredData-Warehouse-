package com.warehouse.warehouse.service;

import com.warehouse.warehouse.Repostory.CustomerRepo;
import com.warehouse.warehouse.Repostory.ValidRepo;
import com.warehouse.warehouse.model.Customer;
import com.warehouse.warehouse.model.ValidDeal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DealServiceImp implements DealService {

    private final ValidRepo validRepo;
    private final CustomerRepo customerRepo;

    @Autowired
    public DealServiceImp(ValidRepo validRepo, CustomerRepo customerRepo) {
        this.validRepo = validRepo;
        this.customerRepo = customerRepo;
    }

    @Override
    public List<ValidDeal> findValidDeals() {
        List<ValidDeal> validDeals = validRepo.findAll();
        return validRepo.findAll();
    }

    @Override
    public ValidDeal findById(String id) {
        return validRepo.getById(id);
    }

    @Override
    public ValidDeal saveValidDeal(ValidDeal validDeal) {
        List<Customer> customerList=new ArrayList<>();
        List<ValidDeal> validDealList=new ArrayList<>();
        validDeal.setDealId(validDeal.getDealId());
        validDeal.setFromCurrency(validDeal.getFromCurrency());
        validDeal.setToCurrency(validDeal.getToCurrency());
        validDeal.setDateTime(validDeal.getDateTime());
        validDeal.setAmount(validDeal.getAmount());

//        if(validDeal.getCustomer().equals("null")){
            validDeal.setAccpet(validDeal.isAccpet());
//        }else {
//            validDeal.setAccpet(true);
//        }

//        customerList = customerRepo.findAll();
//        for (Customer customer: customerList){
//            if(customer.getId().equals(validDeal.getCustomer().getId())){
//                validDeal.setCustomer(customer);
//                validDealList.add(validDeal);
//                customer.setValidDeal(validDealList);
//
//            }
//        }
        return validRepo.save(validDeal);
    }



}
