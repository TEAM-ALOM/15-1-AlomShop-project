package com.example.shopping_mall.cart.cart_item.dto;

import com.example.shopping_mall.cart.cart_item.CartItem;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartItemResponse {
  private Long cartItemId;
  private Long cartId;
  private Long productId;

  public static CartItemResponse from(CartItem cartItem) {
    return CartItemResponse.builder()
        .cartItemId(cartItem.getCartItemId())
        .cartId(cartItem.getCart().getCartId())
        .productId(cartItem.getProduct().getProductId())
        .build();
  }

  public static List<CartItemResponse> fromList(List<CartItem> cartItems) {
    List<CartItemResponse> list = new ArrayList<>();
    for (CartItem cartItem : cartItems) {
      list.add(from(cartItem));
    }
    return list;
  }


}
