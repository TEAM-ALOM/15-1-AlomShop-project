package com.example.shopping_mall.productCategory;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCategoryService {
    private final ProductCategoryRepository categoryRepository;

    public void addCategory(String categoryName) {
        categoryRepository.save(ProductCategory.builder()
                .categoryName(categoryName)
                .build());
    }

    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
