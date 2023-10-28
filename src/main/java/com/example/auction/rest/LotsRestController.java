package com.example.auction.rest;

import com.example.auction.models.Lots;
import com.example.auction.models.StartingPrice;
import com.example.auction.services.LotsService;
import com.example.auction.services.StartingPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class LotsRestController {

    private final LotsService lotsService;
    private final StartingPriceService startingPriceService;

    @Autowired
    public LotsRestController(LotsService lotsService, StartingPriceService startingPriceService) {
        this.lotsService = lotsService;
        this.startingPriceService = startingPriceService;
    }

    @GetMapping("/all/lots")
    public List<Lots> getAllLots() {
        return lotsService.getAllLots();
    }

    @GetMapping("/active/lots")
    public List<Lots> getAllActiveLots() {
        return lotsService.searchActiveLots();
    }


    @GetMapping("/search/lot")
    public List<Lots> searchLotByTitle(@RequestParam String title) {
        return lotsService.searchLotByTittle(title);
    }

    @GetMapping("/search/lot/by/id")
    public Lots viewLot(@RequestParam("id") Long id) {
        return lotsService.findById(id);
    }
}


