package com.brawlaboutitapi.controller;

import com.brawlaboutitapi.entities.RedemptionCodes;
import com.brawlaboutitapi.service.RedemptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/redemption")
public class RedemptionController {

    @Autowired
    private RedemptionService service;

    @GetMapping("/codes")
    List<RedemptionCodes> retrieveAllCodes() {
        return service.retrieveAllCodes();
    }

    @GetMapping("/codes/{id}")
    ResponseEntity<RedemptionCodes> retrieveCodeById(@PathVariable("id") Long id) {
        return service.retrieveCodeById(id);
    }

    @PostMapping("/codes")
    RedemptionCodes createCode(@RequestBody Map<String, Object> redemptionCode) { return service.createCode(redemptionCode); }

    @DeleteMapping("/codes/{id}")
    ResponseEntity<RedemptionCodes> deleteCodeById(@PathVariable("id") Long id) {
        return service.deleteCodeById(id);
    }
}
