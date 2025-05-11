package com.example.shopping_mall.productCategory;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ProductCategoryController {
    private final ProductCategoryService categoryService;

    @PostMapping("/api/product/category")
    public ResponseEntity<String> addCategory(@RequestBody Map<String, String> body) {
        categoryService.addCategory(body.get("categoryName"));
        return ResponseEntity.ok("카테고리 추가 완료");
    }

    @DeleteMapping("/api/product/category")
    public ResponseEntity<String> deleteCategory(@RequestParam Long categoryId) {
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok("카테고리 삭제 완료");
    }
}
