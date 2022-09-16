package com.warehouse.warehouse.Repostory;

import com.warehouse.warehouse.model.Deal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DealRepo extends JpaRepository<Deal, UUID> {
}
