package com.example.auction.controllers;

import com.example.auction.models.Lots;
import com.example.auction.services.LotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    private final LotsService lotsService;
    @Autowired
    public HelloController(LotsService lotsService) {
        this.lotsService = lotsService;
    }
    @GetMapping("hello")
    public String hello(){
        return "Hello World!";
    }
    @GetMapping("/search/{word}")
    public List<Lots> searchByTittle(@PathVariable String word){
         return lotsService.searchLotByTittle(word);
    }
}