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

  // product_category.id로 조회
  List<CartItem> findByProductCategoryId(Long productCategoryId);

  // user.id로 조회
//  List<CartItem> findByCartUserId(Long userId);

  // user.id & product_category.id로 조회
//  List<CartItem> findByCartUserIdAndProductCategoryId(Long userId, Long productCategoryId);
}
