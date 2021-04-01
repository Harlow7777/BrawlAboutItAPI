package com.brawlaboutitapi.service;

import com.brawlaboutitapi.entities.CardDetails;
import com.brawlaboutitapi.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class CardService {

    @Autowired
    public CardRepository repository;

    public List<CardDetails> retrieveAllCards() {
        return repository.findAll();
    }

    public ResponseEntity<CardDetails> retrieveCardById(long id) {
        try {
            return ResponseEntity.ok(repository.findById(id).get());
        } catch(NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    public CardDetails createCard(Map<String, Object> payload) {
        CardDetails cardDetails = new CardDetails();
        cardDetails.setCardId(Long.parseLong((String) payload.get("card_id")));
        cardDetails.setName(payload.get("name").toString());
        return repository.save(cardDetails);
    }


    public ResponseEntity<CardDetails> deleteCardById(Long id) {
        try {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch(NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
