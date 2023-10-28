package com.example.auction.rest;

import com.example.auction.models.Lots;
import com.example.auction.services.LotsService;
import com.example.auction.services.StartingPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LotsRestController {

    private final LotsService lotsService;
    private final StartingPriceService startingPriceService;

    @Autowired
    public LotsRestController(LotsService lotsService,StartingPriceService startingPriceService) {
        this.lotsService = lotsService;
        this.startingPriceService = startingPriceService;
    }

    @GetMapping("/all/lots")
    public List<Lots> getAllLots(){
        return lotsService.getAllLots();
    }
}
