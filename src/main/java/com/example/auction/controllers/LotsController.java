package com.example.auction.controllers;

import com.example.auction.models.Lots;
import com.example.auction.services.LotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LotsController {

    private  final LotsService lotsService;

    @Autowired
    public LotsController(LotsService lotsService) {
        this.lotsService = lotsService;
    }

    @GetMapping("/lots")
    public String getAllLots(Model model){
        List<Lots> lots = lotsService.getAllLots();
        model.addAttribute("lots", lots);

        return "lots-list";
    }
    @PostMapping("/searchLot")
    public String searchLotByTitle(@RequestParam String title, Model model) {
        List<Lots> matchingLots = lotsService.searchLotByTittle(title);
        model.addAttribute("matchingLots", matchingLots);
        return "lot-search-result";
    }
}
