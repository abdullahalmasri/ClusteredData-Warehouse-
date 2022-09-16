package com.warehouse.warehouse.service;

import com.warehouse.warehouse.model.CurrencyCode;
import com.warehouse.warehouse.model.ValidDeal;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface AccumulativeDealService {

    void updateCountOfDealsPerCurrency(Map<CurrencyCode, Long> currencyCountMap);

    Map<CurrencyCode, Long> findAllDealsCurrencyCountMap();

    List<ValidDeal> findAll(String uuid);
}
