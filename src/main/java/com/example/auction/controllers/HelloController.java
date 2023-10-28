/*
package com.example.auction.controllers;

import com.example.auction.models.Lots;
import com.example.auction.models.StartingPrice;
import com.example.auction.services.LotsService;
import com.example.auction.services.StartingPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    private final LotsService lotsService;
    private final StartingPriceService startingPriceService;

    @Autowired
    public HelloController(LotsService lotsService, StartingPriceService startingPriceService) {
        this.lotsService = lotsService;
        this.startingPriceService = startingPriceService;
    }

    @GetMapping("hello")
    public String hello(){
        return "Hello World!";
    }

    @GetMapping("/all")
    public List<Lots> findAll(){
        return lotsService.getAllLots();
    }

    @GetMapping("/active")
    public ResponseEntity<List<Lots>> getActiveLots() {
        List<Lots> activeLots = lotsService.searchActiveLots();
        return ResponseEntity.ok(activeLots);
    }

    @GetMapping("/lot/{id}")
    public Lots getById(@PathVariable Long id){
        return lotsService.findById(id);
    }

    @GetMapping("/url/{id}")
    public ResponseEntity<String> getLotUrl(@PathVariable Long id) {
        String lotUrl = lotsService.generateLotUrl(id);
        if (lotUrl != null) {
            return ResponseEntity.ok(lotUrl);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

*/
