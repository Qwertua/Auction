package com.example.auction.controllers;

import com.example.auction.models.Lots;
import com.example.auction.services.LotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class OwnerLotController {

    private final LotsService lotsService;

    @Autowired
    public OwnerLotController(LotsService lotsService) {
        this.lotsService = lotsService;
    }

    @GetMapping("/delete/{id}")
    public String deleteLot(@PathVariable("id") Long id) {
        System.out.println(id);
        lotsService.deleteByID(id);
        return "redirect:/lots";
    }

    @GetMapping("/generate/{id}")
    public String generateUrl(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        String lotUrl = lotsService.generateLotUrl(id);
        redirectAttributes.addAttribute("lotUrl", lotUrl);
        System.out.println(lotsService.generateLotUrl(id));
        return "redirect:/searchLotById?id=" + id;
    }

    @PostMapping("/start/auction/{id}")
    public String startAuction(@PathVariable Long id, Model model) {
        lotsService.startAuction(id);
        List<Lots> lots = lotsService.searchActiveLots();
        model.addAttribute("lots", lots);
        return "lots-list";
    }

    @PostMapping("/stop/auction/{id}")
    public String stopAuction(@PathVariable Long id, Model model) {
        lotsService.stopAuction(id);
        List<Lots> lots = lotsService.searchActiveLots();
        model.addAttribute("lots", lots);
        return "lots-list";
    }

}
