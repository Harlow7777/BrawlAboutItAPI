package com.brawlaboutitapi.repository;

import com.brawlaboutitapi.entities.RedemptionCodes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedemptionRepository extends JpaRepository<RedemptionCodes, Long> {
}
