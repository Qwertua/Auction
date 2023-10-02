package com.example.auction.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "lots")
public class Lots {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private int currentPrice;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

}