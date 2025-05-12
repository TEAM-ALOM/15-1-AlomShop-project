package com.example.shopping_mall.cart.cart_item;

//import com.example.shopping_mall.user.User;

import com.example.shopping_mall.Product.Product;
import com.example.shopping_mall.ProductCategory.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

  // product.id로 조회
  List<CartItem> findByProductId(Long productId);

  // product.category.categoryId로 조회
  List<CartItem> findByProductCategoryCategoryId(Long categoryId);

  // cart.user.id로 조회
  List<CartItem> findByCartUserId(Long userId);

  // cart.user.id & product.category.categoryId로 조회
  List<CartItem> findByCartUserIdAndProductCategoryCategoryId(Long userId, Long categoryId);
}