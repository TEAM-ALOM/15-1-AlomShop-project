package com.example.shopping_mall.cart.cart_item;

import com.example.shopping_mall.Product.Product;
import com.example.shopping_mall.Product.ProductRepository;
import com.example.shopping_mall.cart.Cart;
import com.example.shopping_mall.cart.CartRepository;
import com.example.shopping_mall.cart.cart_item.dto.CartItemResponse;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // 자동 의존성 주입 해줌
public class CartItemService {

  private final CartItemRepository cartItemRepository;
  private final CartRepository cartRepository;
  private final ProductRepository productRepository;


  // 장바구니에 아이템 추가
  @Transactional // 트랜잭션을 시작하여 성공시 커밋, 실패시 롤백
  public CartItemResponse addCartItem(Long cartId, Long productId) {
    Cart cart = cartRepository.findById(cartId)
        .orElseThrow(() -> new IllegalArgumentException("해당 cart가 존재하지 않습니다. id = " + cartId));

    Product product = productRepository.findById(productId)
        .orElseThrow(
            () -> new IllegalArgumentException("해당 product가 존재하지 않습니다. id = " + productId));

    CartItem cartItem = new CartItem();
    cartItem.setCart(cart);
    cartItem.setProduct(product);

    cartItemRepository.save(cartItem);
    return CartItemResponse.from(cartItem);
  }

  // 장바구니에서 삭제
  public void removeCartItem(List<Long> cartItemIds) {
    for (Long id : cartItemIds) {
      // ID로 CartItem 찾기
      CartItem cartItemToDelete = cartItemRepository.findById(id)
          .orElseThrow(
              () -> new IllegalArgumentException("ID " + id + "에 해당하는 장바구니 항목이 존재하지 않습니다."));

      // 해당 항목 삭제
      cartItemRepository.delete(cartItemToDelete);
    }
  }

  // product.id로 조회
  public List<CartItemResponse> getCartItemsByProductId(Long productId) {
    return CartItemResponse.fromList(cartItemRepository.findByProductId(productId));
  }


  // product_category_id로 조회
  public List<CartItemResponse> getCartItemsByProductCategoryId(Long productCategoryId) {
    return CartItemResponse.fromList(cartItemRepository.findByProductCategoryId(productCategoryId));
  }

/*  // user.id로 조회
  public List<CartItemResponse> getCartItemsByUserId(Long userId) {
    return CartItemResponse.fromList(cartItemRepository.findByCartUserId(userId));
  }

  // user.id & product_category_id로 조회
  public List<CartItemResponse> getCartItemsByUserIdAndProductCategoryId(Long userId,
      Long productCategoryId) {
    return CartItemResponse.fromList(
        cartItemRepository.findByCartUserIdAndProductCategoryId(userId, productCategoryId));
  }*/
}
