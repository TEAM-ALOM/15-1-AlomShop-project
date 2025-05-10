package com.example.shopping_mall.Product.Dto;

import lombok.Data;

@Data
public class ProductRequest {
    private String productName;
    private Long categoryId;
}
