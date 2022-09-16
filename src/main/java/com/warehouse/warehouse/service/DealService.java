package com.warehouse.warehouse.service;

import com.warehouse.warehouse.model.ValidDeal;
import java.util.List;

public interface DealService {
    List<ValidDeal> findValidDeals();
    ValidDeal findById(String id);

    ValidDeal saveValidDeal(ValidDeal validDeal);

}
