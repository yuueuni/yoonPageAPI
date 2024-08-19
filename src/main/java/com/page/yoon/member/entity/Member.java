package com.page.yoon.member.entity;;

import com.page.yoon.common.entity.Base;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@Table(name = "member", schema = "yoonpage")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "phone", length = 255)
    private String phone;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "expired_at")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime expiredAt;

    @Embedded
    private Base base;

}