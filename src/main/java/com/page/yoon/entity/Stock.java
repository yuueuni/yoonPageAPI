package com.page.yoon.entity;

import com.page.yoon.exception.NotEnoughStockException;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "stock", schema = "yoonpage")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "code", length = 255)
    private String code;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "restocked_at")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime restockedAt;

    @Column(name = "status", nullable = false, length = 255)
    private String status;

    @Embedded
    private Base base;

    // 비즈니스 로직
    public void addStock(int quantity) {
        this.quantity += quantity;
    }

    public void removeStock(int quantity) {
        int restStock = this.quantity - quantity;
        if (restStock < 0) {
            throw new NotEnoughStockException("need more stock");
        }
        this.quantity = restStock;
    }
}
