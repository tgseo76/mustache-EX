package com.mustache.bbs.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long number;

    @Column(nullable = false) //not null
    private String name;

    @Column(nullable = false) //not null
    private Integer price;

    @Column(nullable = false) //not null
    private Integer stock;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;



}
