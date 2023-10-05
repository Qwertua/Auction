package com.example.auction.controllers;

import com.example.auction.models.Lots;
import com.example.auction.models.StartingPrice;
import com.example.auction.services.LotsService;
import com.example.auction.services.StartingPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String getAllLots(@RequestParam(name = "createdLotId", required = false) Long createdLotId, Model model){
        List<Lots> lots = lotsService.searchActiveLots();
        model.addAttribute("lots", lots);
        if (createdLotId != null) {
            model.addAttribute("createdLotId", createdLotId);
        }
        return "lots-list";
    }

    @GetMapping("/addLot")
    public String showAddLotForm(Model model) {
        model.addAttribute("lot", new Lots());
        return "add-lot";
    }

    @PostMapping("/addLot")
    public String addLot(@ModelAttribute Lots lot, @RequestParam("price") int price, Model model) {
        StartingPrice startingPrice = new StartingPrice();
        startingPrice.setPrice(price);
        startingPrice = startingPriceService.save(startingPrice);
        lot.setStartingPrice(startingPrice);
        Lots createdLot = lotsService.createLots(lot);
        model.addAttribute("createdLotId", createdLot.getId());
        return "redirect:/lots?createdLotId=" + createdLot.getId();
    }

    @PostMapping("/searchLot")
    public String searchLotByTitle(@RequestParam String title, Model model) {
        List<Lots> matchingLots = lotsService.searchLotByTittle(title);
        model.addAttribute("matchingLots", matchingLots);
        return "lot-search-result";
    }

    @GetMapping("/searchLotById")
    public String viewLot(@RequestParam("id") Long id, Model model) {
        Lots lot = lotsService.findById(id);
        model.addAttribute("lots", lot);
        return "view-lot";
    }
}
