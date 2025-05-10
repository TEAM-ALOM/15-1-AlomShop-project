package com.example.shopping_mall.cart.cart_item.dto;

import lombok.Data;

@Data
public class CartItemRequest {
  private Long cartItemId;
  private Long cartId;
  private Long productId;
}
