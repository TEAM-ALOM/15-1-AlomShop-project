package com.example.shopping_mall.order.dto;


import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
public class OrderSearchRequestDto {
    private Long orderId;
    private Long userId;
    private Long productId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate orderDate;
}
