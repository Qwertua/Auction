package com.example.auction.repo;

import com.example.auction.models.Lots;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LotRepository extends JpaRepository<Lots, Long> {
    List<Lots> findByTitleContaining(String word);
}

