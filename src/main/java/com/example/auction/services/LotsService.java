package com.example.auction.services;

import com.example.auction.models.Lots;
import com.example.auction.models.StartingPrice;
import com.example.auction.models.Users;
import com.example.auction.repo.LotRepository;
import com.example.auction.repo.StartingPriceRepository;
import com.example.auction.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



@Service
public class LotsService {

    private final LotRepository lotRepository;
    private final UserRepository userRepository;
    private final StartingPriceRepository startingPriceRepository;
    private final Map<Long, Boolean> auctionStatusMap = new HashMap<>();

    @Autowired
    public LotsService(LotRepository lotRepository, UserRepository userRepository,StartingPriceRepository startingPriceRepository) {
        this.lotRepository = lotRepository;
        this.userRepository = userRepository;
        this.startingPriceRepository = startingPriceRepository;
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
                .filter(lot -> currentTime.isAfter(lot.getStartTime()) && currentTime.isBefore(lot.getEndTime()) && isAuctionRunning(lot.getId()))
                .collect(Collectors.toList());
    }

    public void startAuction(Long lotId) {
        auctionStatusMap.put(lotId, true);
    }

    public void stopAuction(Long lotId) {
        auctionStatusMap.put(lotId, false);
    }

    private boolean isAuctionRunning(Long lotId) {
        return auctionStatusMap.getOrDefault(lotId, false);
    }

    public List<Lots> searchLotByTittle(String word) {
        return lotRepository.findByTitleContaining(word);
    }

    public String generateLotUrl(Long id) {
        return "http://localhost:8080/searchLotById?id=" + id;
    }

    public Lots addLotToUser(Long userId, Lots lot) {
        Users user = userRepository.findById(userId).orElse(null);

        StartingPrice startingPrice = new StartingPrice();
        startingPrice.setPrice(lot.getStartingPrice().getPrice());
        startingPrice = startingPriceRepository.save(startingPrice);

        lot.setStartingPrice(startingPrice);
        lot.setUser(user);

        return lotRepository.save(lot);
    }
}
