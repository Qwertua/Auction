package com.example.auction.rest;

import com.example.auction.models.Lots;
import com.example.auction.models.StartingPrice;
import com.example.auction.services.LotsService;
import com.example.auction.services.StartingPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class LotsRestController {

    private final LotsService lotsService;

    @Autowired
    public LotsRestController(LotsService lotsService) {
        this.lotsService = lotsService;
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

    @PostMapping("/lots/{userId}")
    public ResponseEntity<Lots> addLotToUser(@PathVariable Long userId, @RequestBody Lots lot) {
        System.out.println(lot);
        return new ResponseEntity<>(lotsService.addLotToUser(userId, lot), HttpStatus.CREATED);
    }
}


