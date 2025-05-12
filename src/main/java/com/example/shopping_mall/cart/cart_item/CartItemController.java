package com.example.shopping_mall.cart.cart_item;

import com.example.shopping_mall.cart.cart_item.dto.CartItemRequest;
import com.example.shopping_mall.cart.cart_item.dto.CartItemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartItemController {

  private final CartItemService cartItemService;

  // 장바구니에 아이템 추가
  @PostMapping
  public ResponseEntity<CartItemResponse> addCartItem(
      @RequestBody CartItemRequest request
  ) {
    CartItemResponse response = cartItemService.addCartItem(
        request.getCartId(),
        request.getProductId()
    );
    return ResponseEntity.ok(response);
  }

  // 장바구니 아이템 삭제 (다수 가능)
  @DeleteMapping
  public ResponseEntity<Void> removeCartItems(@RequestBody List<Long> cartItemIds) {
    cartItemService.removeCartItem(cartItemIds);
    return ResponseEntity.noContent().build();
  }

  // productId로 장바구니 항목 조회
  @GetMapping("/product")
  public ResponseEntity<List<CartItemResponse>> getCartItemsByProductId(
      @RequestParam Long productId
  ) {
    return ResponseEntity.ok(cartItemService.getCartItemsByProductId(productId));
  }

  // productCategoryId로 장바구니 항목 조회
  @GetMapping("category")
  public ResponseEntity<List<CartItemResponse>> getCartItemsByProductCategoryId(
      @RequestParam Long productCategoryId
  ) {
    return ResponseEntity.ok(cartItemService.getCartItemsByProductCategoryId(productCategoryId));
  }

  // userId&productCategoryId로 조회 (User 기능 미구현 상태로 주석)
    @GetMapping("user-category")
    public ResponseEntity<List<CartItemResponse>> getCartItemsByUserIdAndCategory(
            @RequestParam Long userId,
            @RequestParam Long productCategoryId
    ) {
        return ResponseEntity.ok(
            cartItemService.getCartItemsByUserIdAndProductCategoryId(userId, productCategoryId)
        );
    }

  @GetMapping
  public ResponseEntity<List<CartItemResponse>> getAllCartItems() {
    return ResponseEntity.ok(cartItemService.getAllCartItems());
  }

}
