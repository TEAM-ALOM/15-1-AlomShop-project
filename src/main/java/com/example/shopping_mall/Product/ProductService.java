package com.example.shopping_mall.Product;

import com.example.shopping_mall.Product.Dto.ProductRequest;
import com.example.shopping_mall.Product.Dto.ProductResponse;
import com.example.shopping_mall.ProductCategory.ProductCategory;
import com.example.shopping_mall.ProductCategory.ProductCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductCategoryRepository categoryRepository;

    public ProductResponse addProduct(ProductRequest dto) {
        ProductCategory category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("카테고리 없음"));
        Product product = Product.builder()
                .productName(dto.getProductName())
                .category(category)
                .build();
        return ProductResponse.from(productRepository.save(product));
    }

    public List<ProductResponse> getProducts() {
        return ProductResponse.fromList(productRepository.findAll());
    }

    public ProductResponse getProductById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("상품 없음"));
        return ProductResponse.from(product);
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}
