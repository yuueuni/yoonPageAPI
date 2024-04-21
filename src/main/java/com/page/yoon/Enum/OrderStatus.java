package com.page.yoon.Enum;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum OrderStatus {
    COMPLETE("COMPLETE", "완료");

    private String code;
    private String name;
}
