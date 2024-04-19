package com.page.yoon.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "product_option", schema = "yoonpage")
public class ProductOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "product_id", nullable = false)
    private Integer productId;

    @Column(name = "option_id", nullable = false)
    private Integer optionId;

    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

}

