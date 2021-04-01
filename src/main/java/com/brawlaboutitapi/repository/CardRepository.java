package com.brawlaboutitapi.repository;

import com.brawlaboutitapi.entities.CardDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<CardDetails, Long> {
}
