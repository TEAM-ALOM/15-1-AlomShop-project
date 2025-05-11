package com.example.shopping_mall.product.dto;

import lombok.Data;

@Data
public class ProductRequest {
    private String productName;
    private Long categoryId;
}
