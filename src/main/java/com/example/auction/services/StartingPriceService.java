package com.example.auction.services;

import com.example.auction.models.Lots;
import com.example.auction.models.StartingPrice;
import com.example.auction.repo.StartingPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StartingPriceService {

    private final StartingPriceRepository startingPriceRepository;
    private final LotsService lotsService;

    @Autowired
    public StartingPriceService(StartingPriceRepository startingPriceRepository, LotsService lotsService) {
        this.startingPriceRepository = startingPriceRepository;
        this.lotsService = lotsService;
    }

    public void updatePriceByLotTitle(String lotTitle, int newPrice) {
        List<Lots> lotList = lotsService.searchLotByTittle(lotTitle);

        if (!lotList.isEmpty()) {
            for (Lots lot : lotList) {
                StartingPrice startingPrice = lot.getStartingPrice();

                if (newPrice > startingPrice.getPrice()) {
                    startingPrice.setPrice(newPrice);
                    startingPriceRepository.save(startingPrice);
                } else {
                    throw new IllegalArgumentException("Updated price must be > existing price");
                }
            }
        } else {
            throw new IllegalArgumentException("Lot not found with title: " + lotTitle);
        }
    }

    public StartingPrice save(StartingPrice startingPrice) {
        return startingPriceRepository.save(startingPrice);
    }
}
