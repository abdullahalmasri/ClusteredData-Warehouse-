package com.warehouse.warehouse.model;
/**
 * here we extend the generated id where each deal now have
 * unique id and name file
 * */

import com.warehouse.warehouse.model.AbstractDomain;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public class Deal extends AbstractDomain {

    @Column(name = "file_name")
    private String fileName;

    public Deal() {

    }

}
