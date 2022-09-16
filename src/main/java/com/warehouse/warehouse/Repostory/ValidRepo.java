package com.warehouse.warehouse.Repostory;

import com.warehouse.warehouse.model.ValidDeal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ValidRepo extends JpaRepository<ValidDeal, UUID> {
    ValidDeal getById(String id);
}
