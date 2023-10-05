package com.example.auction.controllers;

import com.example.auction.services.StartingPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StartingPriceController {

    private final StartingPriceService startingPriceService;

    @Autowired
    public StartingPriceController(StartingPriceService startingPriceService) {
        this.startingPriceService = startingPriceService;
    }

    @PostMapping("/updatePrice")
    public String updatePrice(@RequestParam("lotTitle") String lotTitle, @RequestParam("newPrice") int newPrice) {
        try {
            startingPriceService.updatePriceByLotTitle(lotTitle, newPrice);
            return "redirect:/lots";
        } catch (IllegalArgumentException e) {
            return "redirect:/error";
        }
    }
}
