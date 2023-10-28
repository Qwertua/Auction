package com.example.auction.rest;

import com.example.auction.services.LotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class OwnerLotRestController {

    private final LotsService lotsService;

    @Autowired
    public OwnerLotRestController(LotsService lotsService) {
        this.lotsService = lotsService;
    }
    @GetMapping("/delete")
    public void deleteLot(@RequestParam("id") Long id) {
        lotsService.deleteByID(id);
    }
    @GetMapping("/generate")
    public String generateUrl(@RequestParam Long id) {
        return lotsService.generateLotUrl(id);
    }

    @PostMapping("/start/auction")
    public void startAuction(@RequestParam Long id) {
        lotsService.startAuction(id);
    }
    @PostMapping("/stop/auction")
    public void stopAuction(@RequestParam Long id) {
        lotsService.stopAuction(id);
    }
}

