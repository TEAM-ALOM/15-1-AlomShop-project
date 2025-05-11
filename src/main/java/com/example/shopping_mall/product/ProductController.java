package com.example.shopping_mall.product;

import com.example.shopping_mall.product.dto.ProductRequest;
import com.example.shopping_mall.product.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/api/product")
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest dto) {
        return ResponseEntity.ok(productService.addProduct(dto));
    }

    @GetMapping("/api/product")
    public ResponseEntity<?> getProduct(@RequestParam(required = false) Long productId) {
        if (productId != null) {
            return ResponseEntity.ok(productService.getProductById(productId));
        }
        return ResponseEntity.ok(productService.getProducts());
    }

    @DeleteMapping("/api/product")
    public ResponseEntity<String> deleteProduct(@RequestParam Long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.ok("상품 삭제 완료");
    }
}
