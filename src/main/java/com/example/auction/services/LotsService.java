package com.example.auction.services;

import com.example.auction.models.Lots;
import com.example.auction.repo.LotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LotsService {

    private final LotRepository lotRepository;

    @Autowired
    public LotsService(LotRepository lotRepository) {
        this.lotRepository = lotRepository;
    }

    public Lots findById(Long id) {
        return lotRepository.findById(id).orElse(null);
    }

    public Lots createLots(Lots lots) {
        return lotRepository.save(lots);
    }

    public void deleteByID(Long id) {
        lotRepository.deleteById(id);
    }

    public List<Lots> getAllLots() {
        return lotRepository.findAll();
    }

    public List<Lots> searchActiveLots() {
        LocalDateTime currentTime = LocalDateTime.now();
        return getAllLots().stream()
                .filter(lot -> currentTime.isAfter(lot.getStartTime()) && currentTime.isBefore(lot.getEndTime()))
                .collect(Collectors.toList());
    }

    public List<Lots> searchLotByTittle(String word) {
        return lotRepository.findByTitleContaining(word);
    }

    public String generateLotUrl(Long id) {
        String baseUrl = "http://localhost:8080/lot/{id}";
        return UriComponentsBuilder.fromHttpUrl(baseUrl)
                .buildAndExpand(id)
                .toUriString();
    }
}
