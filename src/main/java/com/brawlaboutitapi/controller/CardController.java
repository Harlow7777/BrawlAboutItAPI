package com.brawlaboutitapi.controller;

import com.brawlaboutitapi.entities.CardDetails;
import com.brawlaboutitapi.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    public CardService service;

    @GetMapping("/codes")
    List<CardDetails> retrieveAllCodes() {
        return service.retrieveAllCards();
    }

    @GetMapping("/codes/{id}")
    ResponseEntity<CardDetails> retrieveCodeById(@PathVariable("id") Long id) {
        return service.retrieveCardById(id);
    }

    @PostMapping("/codes")
    CardDetails createCode(@RequestBody Map<String, Object> redemptionCode) { return service.createCard(redemptionCode); }

    @DeleteMapping("/codes/{id}")
    ResponseEntity<CardDetails> deleteCodeById(@PathVariable("id") Long id) {
        return service.deleteCardById(id);
    }
}
