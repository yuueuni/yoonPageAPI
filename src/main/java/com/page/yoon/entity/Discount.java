package com.page.yoon.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "discount", schema = "yoonpage")
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "type", nullable = false, length = 255)
    private String type;

    @Column(name = "price")
    private Integer price;

    @Column(name = "rate")
    private Integer rate;

    @Column(name = "start")
    @Temporal(TemporalType.TIMESTAMP)
    private Date start;

    @Column(name = "end")
    @Temporal(TemporalType.TIMESTAMP)
    private Date end;

    @Column(name = "product_id", nullable = false)
    private Integer productId;

    @Embedded
    private Base base;

}
