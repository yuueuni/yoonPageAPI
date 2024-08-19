package com.page.yoon.entity;

import com.page.yoon.common.entity.Base;
import jakarta.persistence.*;

@Entity
@Table(name = "payment", schema = "yoonpage")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "product_total_price", nullable = false)
    private Integer productTotalPrice;

    @Column(name = "discount", nullable = false)
    private Integer discount;

    @Column(name = "delivery_price", nullable = false)
    private Integer deliveryPrice;

    @Column(name = "pay_price", nullable = false)
    private Integer payPrice;

    @Column(name = "cancel_price", nullable = false)
    private Integer cancelPrice;

    @Column(name = "pg_type", nullable = false, length = 255)
    private String pgType;

    @Embedded
    private Base base;

}
