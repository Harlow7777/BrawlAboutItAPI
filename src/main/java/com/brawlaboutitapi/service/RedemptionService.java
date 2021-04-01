package com.brawlaboutitapi.service;

import com.brawlaboutitapi.entities.RedemptionCodes;
import com.brawlaboutitapi.repository.RedemptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class RedemptionService {

    @Autowired
    RedemptionRepository repository;

    public List<RedemptionCodes> retrieveAllCodes() {
        return repository.findAll();
    }

    public ResponseEntity<RedemptionCodes> retrieveCodeById(long id) {
        try {
            return ResponseEntity.ok(repository.findById(id).get());
        } catch(NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    public RedemptionCodes createCode(Map<String, Object> payload) {
        RedemptionCodes redemptionCode = new RedemptionCodes();
        redemptionCode.setCode(Long.parseLong((String) payload.get("code")));
        redemptionCode.setCard_id((Integer) payload.get("card_id"));
        return repository.save(redemptionCode);
    }


    public ResponseEntity<RedemptionCodes> deleteCodeById(Long id) {
        try {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch(NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
