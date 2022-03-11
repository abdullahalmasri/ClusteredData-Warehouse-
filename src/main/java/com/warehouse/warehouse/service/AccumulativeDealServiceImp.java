package com.warehouse.warehouse.service;

import com.warehouse.warehouse.Repostory.AccumulativeDealRepo;
import com.warehouse.warehouse.model.AccumulativeDeal;
import com.warehouse.warehouse.model.CurrencyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AccumulativeDealServiceImp implements AccumulativeDealService {
//    private EntityManager entityManager;
//    private AccumulativeDealRepo accumulativeDealCountRepository;
//
//    @Autowired
//    public void setAccumulativeDealCountRepository(AccumulativeDealRepo accumulativeDealCountRepository) {
//        this.accumulativeDealCountRepository = accumulativeDealCountRepository;
//    }
//    @PersistenceContext
//    public void setEntityManager(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
    @Override
    public void updateCountOfDealsPerCurrency(Map<CurrencyCode, Long> currencyCountMap) {
//        final List<AccumulativeDeal> accumulativeDealCounts = accumulativeDealCountRepository.findAll();
//
//        accumulativeDealCounts.forEach(accumulativeDealCount -> {
//            accumulativeDealCount.setCountOfDeals(currencyCountMap.get(accumulativeDealCount.getFromCurrency()));
//        });

//        accumulativeDealCountRepository.save(accumulativeDealCounts);

    }

    @Override
    public Map<CurrencyCode, Long> findAllDealsCurrencyCountMap() {
//        final TypedQuery<Object[]> typedQuery = entityManager.createQuery("SELECT adc.currencyCode, adc.countOfDeals FROM AccumulativeDealCount adc", Object[].class);
//
//        final List<Object[]> result = typedQuery.getResultList();
//
//        final Map<CurrencyCode, Long> map = new HashMap<>(result.size());
//
//        for (Object[] obj : result) {
//            map.put((CurrencyCode) obj[0], (Long) obj[1]);
//        }

        return null;
    }
}
