package com.warehouse.warehouse.model;
/**
 * here we gonna generate unique id using the UUID
 * */
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
public abstract class AbstractDomain {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @Setter(AccessLevel.NONE)
    private String id;

    public AbstractDomain() {
        this.id = UUID.randomUUID().toString();
    }

}