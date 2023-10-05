package com.example.auction.services;

import com.example.auction.models.StartingPrice;
import com.example.auction.repo.StartingPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StartingPriceService {

    private final StartingPriceRepository startingPriceRepository;

    @Autowired
    public StartingPriceService(StartingPriceRepository startingPriceRepository) {
        this.startingPriceRepository = startingPriceRepository;
    }

    public StartingPrice updatePriceById(Long id, StartingPrice updatedPrice) {

        Optional<StartingPrice> optionalStartingPrice = startingPriceRepository.findById(id);
        StartingPrice existingPrice = optionalStartingPrice.get();

        if (updatedPrice.getPrice() > existingPrice.getPrice()) {
            existingPrice.setPrice(updatedPrice.getPrice());
            return startingPriceRepository.save(existingPrice);
        } else {
            throw new IllegalArgumentException("Updated price must be > existing price");
        }
    }

    public StartingPrice save(StartingPrice startingPrice) {
        return startingPriceRepository.save(startingPrice);
    }
}
