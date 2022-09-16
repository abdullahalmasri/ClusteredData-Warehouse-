package com.warehouse.warehouse.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
public class AbstractIdCustomer {

    @Id
    @Column(name = "customer_id", nullable = false, unique = true)
    @Setter(AccessLevel.NONE)
    private String id;

    public AbstractIdCustomer() {
        this.id = UUID.randomUUID().toString();
    }

}
