package com.page.yoon.entity;

import jakarta.persistence.*;



@Entity
@Table(name = "category", schema = "yoonpage")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "target", nullable = false, length = 255)
    private String target;

    @Column(name = "used", nullable = false, length = 255)
    private String used;

    @Embedded
    private Base base;

}
