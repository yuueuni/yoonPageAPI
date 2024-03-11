package com.page.yoon.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "stock", schema = "yoonpage")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "code", length = 255)
    private String code;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "restocked_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date restockedAt;

    @Column(name = "status", nullable = false, length = 255)
    private String status;

    @Embedded
    private Base base;

}
