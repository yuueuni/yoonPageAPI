package com.page.yoon.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "delivery", schema = "yoonpage")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "country", nullable = false, length = 255)
    private String country;

    @Column(name = "city", nullable = false, length = 255)
    private String city;

    @Column(name = "address", nullable = false, length = 255)
    private String address;

    @Column(name = "zipcode", nullable = false, length = 255)
    private String zipcode;

    @Column(name = "memo", length = 255)
    private String memo;

    @Embedded
    private Base base;

}
