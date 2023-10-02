package com.example.auction.services;

import com.example.auction.models.StartingPrice;
import com.example.auction.repo.StartingPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class StartingPriceService {

    private final StartingPriceRepository repository;
    @Autowired
    public StartingPriceService(StartingPriceRepository repository) {
        this.repository = repository;
    }

    public StartingPrice updatePriceById(Long id, StartingPrice updatedPrice) {
        Optional<StartingPrice> optionalStartingPrice = repository.findById(id);
        StartingPrice existingPrice = optionalStartingPrice.get();
        if (updatedPrice.getPrice() > existingPrice.getPrice()) {
            existingPrice.setPrice(updatedPrice.getPrice());
            return repository.save(existingPrice);
        }
        else {
            throw new IllegalArgumentException("Updated price must be > existing price");

        }
    }

}
