package com.page.yoon.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "option", schema = "yoonpage")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "price")
    private Integer price;

    @Column(name = "stock_id", nullable = false)
    private Integer stockId;

    @Embedded
    private Base base;

}
