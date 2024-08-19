package com.page.yoon.entity;

import com.page.yoon.common.entity.Base;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "discount", schema = "yoonpage")
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "type", nullable = false, length = 255)
    private String type;

    @Column(name = "price")
    private Integer price;

    @Column(name = "rate")
    private Integer rate;

    @Column(name = "start")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime start;

    @Column(name = "end")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime end;

    @Embedded
    private Base base;

}
