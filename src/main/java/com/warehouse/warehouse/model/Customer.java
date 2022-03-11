package com.warehouse.warehouse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
@Data
public class Customer extends AbstractDomain{
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "customer")
    private List<ValidDeal> validDeal;


}
