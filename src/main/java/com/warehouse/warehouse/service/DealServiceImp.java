package com.warehouse.warehouse.service;

import com.warehouse.warehouse.Repostory.ValidRepo;
import com.warehouse.warehouse.model.ValidDeal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealServiceImp implements DealService {

    private final ValidRepo validRepo;

    @Autowired
    public DealServiceImp(ValidRepo validRepo) {
        this.validRepo = validRepo;
    }

    @Override
    public List<ValidDeal> findValidDeals() {
        return validRepo.findAll();
    }

    @Override
    public ValidDeal findById(String id) {
        return validRepo.getById(id);
    }

    @Override
    public ValidDeal saveValidDeal(ValidDeal validDeal) {
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
//        validDeal.setCustomer(validDeal.getCustomer());
        return validRepo.save(validDeal);
    }



}
