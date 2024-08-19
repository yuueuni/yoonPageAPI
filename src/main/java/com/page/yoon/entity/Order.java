package com.page.yoon.entity;

import com.page.yoon.common.entity.Base;
import com.page.yoon.member.entity.Member;
import jakarta.persistence.*;

@Entity
@Table(name = "order", schema = "yoonpage")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "serial_code", nullable = false)
    private String serialCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Embedded
    private Base base;

}