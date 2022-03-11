package com.warehouse.warehouse.DTO;

import lombok.Data;

@Data
public class WarehouseDto {
    private String dealId;

    private String fromCurrency;

    private String toCurrency;

    private String dateTime;

    private String amount;

    public WarehouseDto() {

    }
}