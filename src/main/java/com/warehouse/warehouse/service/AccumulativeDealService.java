package com.warehouse.warehouse.service;

import com.warehouse.warehouse.model.CurrencyCode;

import java.util.Map;

public interface AccumulativeDealService {

    void updateCountOfDealsPerCurrency(Map<CurrencyCode, Long> currencyCountMap);

    Map<CurrencyCode, Long> findAllDealsCurrencyCountMap();
}
