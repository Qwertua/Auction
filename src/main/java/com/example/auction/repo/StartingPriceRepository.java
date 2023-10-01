package com.example.auction.repo;

import com.example.auction.models.StartingPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StartingPriceRepository extends JpaRepository<StartingPrice,Long> {

}
