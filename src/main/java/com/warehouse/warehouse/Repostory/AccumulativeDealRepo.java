package com.warehouse.warehouse.Repostory;

import com.warehouse.warehouse.model.AccumulativeDeal;
import com.warehouse.warehouse.model.ValidDeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface AccumulativeDealRepo extends JpaRepository<AccumulativeDeal,Long> {
    @Query("SELECT d FROM ValidDeal d WHERE d.dealId=:dealId")
    List<ValidDeal> fetchData(@Param("dealId") String dealId);
}
