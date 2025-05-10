package com.example.shopping_mall.cart.cart_item;

import com.example.shopping_mall.Product.Product;
import com.example.shopping_mall.cart.Cart;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // 게터, 세터, toString, EqualsAndHashCode, RequiredArgsContructor 자동 생성
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int cartItemId;

  @ManyToOne
  private Cart cart;

  @ManyToOne
  private Product product;

}
