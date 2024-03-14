package com.page.yoon.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter @Setter
@Table(name = "product", schema = "yoonpage")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "discount_type", length = 255)
    private String discountType;

    @Column(name = "category_id", nullable = false)
    private Integer categoryId;

    @Embedded
    private Base base;

}
