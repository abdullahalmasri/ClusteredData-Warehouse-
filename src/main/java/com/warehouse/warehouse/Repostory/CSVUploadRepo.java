package com.warehouse.warehouse.Repostory;

import com.warehouse.warehouse.model.ValidDeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CSVUploadRepo extends JpaRepository<ValidDeal, UUID> {
}
