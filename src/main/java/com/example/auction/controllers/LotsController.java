package com.example.auction.controllers;

import com.example.auction.models.Lots;
import com.example.auction.models.StartingPrice;
import com.example.auction.services.LotsService;
import com.example.auction.services.StartingPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LotsController {

    private final LotsService lotsService;
    private final StartingPriceService startingPriceService;

    @Autowired
    public LotsController(LotsService lotsService,StartingPriceService startingPriceService) {
        this.lotsService = lotsService;
        this.startingPriceService = startingPriceService;
    }

    @GetMapping("/lots")
    public String getAllLots(Model model){
        List<Lots> lots = lotsService.getAllLots();
        model.addAttribute("lots", lots);
        return "lots-list";
    }

    @GetMapping("/addLot")
    public String showAddLotForm(Model model) {
        model.addAttribute("lot", new Lots());
        return "add-lot";
    }

    @PostMapping("/addLot")
    public String addLot(@ModelAttribute Lots lot, @RequestParam("price") int price) {
        StartingPrice startingPrice = new StartingPrice();
        startingPrice.setPrice(price);
        startingPrice = startingPriceService.save(startingPrice);
        lot.setStartingPrice(startingPrice);
        lotsService.createLots(lot);
        return "redirect:/lots";
    }

    @PostMapping("/searchLot")
    public String searchLotByTitle(@RequestParam String title, Model model) {
        List<Lots> matchingLots = lotsService.searchLotByTittle(title);
        model.addAttribute("matchingLots", matchingLots);
        return "lot-search-result";
    }
}
