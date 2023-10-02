package com.example.auction.models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "starting_price")
public class StartingPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int price;
}
