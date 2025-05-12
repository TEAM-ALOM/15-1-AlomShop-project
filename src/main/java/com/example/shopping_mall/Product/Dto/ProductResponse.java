package com.example.shopping_mall.Product.Dto;

import com.example.shopping_mall.Product.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private Long productId;
    private String productName;
    private String categoryName;

    public static ProductResponse from(Product product) {
        return ProductResponse.builder()
                .productId(product.getId())
                .productName(product.getProductName())
                .categoryName(
                        product.getCategory() != null ? product.getCategory().getCategoryName() : null
                )
                .build();
    }

    public static List<ProductResponse> fromList(List<Product> list) {
        return list.stream().map(ProductResponse::from).collect(Collectors.toList());
    }
}
