package com.example.shopping_mall.order.dto;


import lombok.Getter;

import java.time.LocalDate;


@Getter
public class OrderRequestDto {
    private Long userId;
    private Long productId;
    private LocalDate orderDate;
    private int quantity;
}
