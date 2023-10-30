package com.example.auction.rest;

import com.example.auction.services.LotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class OwnerLotRestController {

    private final LotsService lotsService;

    @Autowired
    public OwnerLotRestController(LotsService lotsService) {
        this.lotsService = lotsService;
    }

    @GetMapping("/delete/lot")
    public void deleteLot(@RequestParam("id") Long id) {
        lotsService.deleteByID(id);
    }

    @GetMapping("/generate/url")
    public ResponseEntity<String> generateUrl(@RequestParam Long id) {
        return ResponseEntity.ok(lotsService.generateLotUrl(id));
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

