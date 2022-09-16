package com.warehouse.warehouse.service;

import com.warehouse.warehouse.DTO.WarehouseDto;
import com.warehouse.warehouse.Repostory.AccumulativeDealRepo;
import com.warehouse.warehouse.model.AccumulativeDeal;
import com.warehouse.warehouse.model.CurrencyCode;
import com.warehouse.warehouse.model.ValidDeal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class AccumulativeDealServiceImp implements AccumulativeDealService {
    @Autowired
    private final AccumulativeDealRepo accumulativeDealRepo;
    private static final Logger log = LoggerFactory.getLogger(AccumulativeDealServiceImp.class);

    public AccumulativeDealServiceImp(AccumulativeDealRepo accumulativeDealRepo) {
        this.accumulativeDealRepo = accumulativeDealRepo;
    }

    @Override
    public void updateCountOfDealsPerCurrency(Map<CurrencyCode, Long> currencyCountMap) {
        final List<AccumulativeDeal> accumulativeDeals = accumulativeDealRepo.findAll();

        accumulativeDeals.forEach(accumulativeDealCount -> {
            accumulativeDealCount.setCountOfDeals(currencyCountMap.get(accumulativeDealCount.getFromCurrency()));
        });

//        accumulativeDealRepo.save(accumulativeDeals);

    }

    @Override
    public Map<CurrencyCode, Long> findAllDealsCurrencyCountMap() {

        return null;
    }

    @Override
    public List<ValidDeal> findAll(String uuid) {
        long count = 0;
        AccumulativeDeal accumulativeDeal =new AccumulativeDeal();
        List<ValidDeal> validDeals=accumulativeDealRepo.fetchData(uuid);
        for (ValidDeal validDeal:validDeals) {
            accumulativeDeal.setDealId(uuid);
            count = count +1;
            accumulativeDeal.setCustomerId(String.valueOf(validDeal.getCustomer().getId()));
            accumulativeDeal.setFromCurrency(validDeal.getFromCurrency());
            accumulativeDeal.setToCurrency(validDeal.getToCurrency());
            accumulativeDeal.setCountOfDeals(count);
            accumulativeDealRepo.save(accumulativeDeal);
        }
        log.info("the Accumulative deal in database are {}",accumulativeDealRepo.findAll().size());
        return validDeals;
    }
}
