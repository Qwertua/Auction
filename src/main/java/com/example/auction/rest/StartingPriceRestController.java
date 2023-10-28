package com.example.auction.rest;

import com.example.auction.services.StartingPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class StartingPriceRestController {
    private final StartingPriceService startingPriceService;

    @Autowired
    public StartingPriceRestController(StartingPriceService startingPriceService) {
        this.startingPriceService = startingPriceService;
    }

    @PostMapping("/update/price")
    public void updatePrice(@RequestParam("title") String title, @RequestParam("price") int price) {
        startingPriceService.updatePriceByLotTitle(title, price);
    }
}
