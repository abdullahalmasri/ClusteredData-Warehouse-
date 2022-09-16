package com.warehouse.warehouse.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "accumulative_deal")
@Data
public class AccumulativeDeal {
    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "from_currency")
    @Enumerated(EnumType.STRING)
    private CurrencyCode fromCurrency;
    @Column(name = "to_currency")
    @Enumerated(EnumType.STRING)
    private CurrencyCode toCurrency;

    @Column(name = "deal_id")
    private String dealId;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "count_of_deals")
    private long countOfDeals = 0;



    public AccumulativeDeal() {

    }

//    public AccumulativeDeal(CurrencyCode currencyCode) {
//        this.currencyCode = currencyCode;
//    }
}
