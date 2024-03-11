package com.page.yoon.entity;;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Entity
@Getter @Setter
@Table(name = "member", schema = "yoonpage")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "pw", nullable = false, length = 255)
    private String password;

    @Column(name = "phone", length = 255)
    private String phone;

    @Embedded
    private Base base;

    @Column(name = "expired_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiredAt;

}