package com.example.shopping_mall.order;


import com.example.shopping_mall.Product.Product;
import com.example.shopping_mall.Product.ProductRepository;
import com.example.shopping_mall.order.dto.OrderSearchRequestDto;
import com.example.shopping_mall.order.order_item.OrderItem;
import com.example.shopping_mall.order.order_item.OrderItemRepository;
import com.example.shopping_mall.user.User;
import com.example.shopping_mall.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Transactional
    public Order createOrder(Long userId, Long productId, LocalDate orderDate,int quantity) {

        User user = userRepository.findById(userId)
               .orElseThrow(() -> new IllegalArgumentException("사용자 없음"));
        Product product = productRepository.findById(productId)
               .orElseThrow(() -> new IllegalArgumentException("상품 없음"));

        OrderItem orderItem = OrderItem.builder()
                .product(product)
                .quantity(quantity)
                .build();

        Order order = Order.builder()
                .user(user)
                .orderDate(orderDate)
                .orderItems(List.of(orderItem))
                .build();


        orderItem.setOrder(order);

        return orderRepository.save(order);
    }


    public List<Order> findOrder(OrderSearchRequestDto dto){

        List<Order> orders = orderRepository.findAll();

        return orders.stream()
                .filter(order -> dto.getOrderId() == null || order.getOrderId().equals(dto.getOrderId()))
                .filter(order -> dto.getOrderDate() == null || order.getOrderDate().equals(dto.getOrderDate()))
                .filter(order -> dto.getUserId() == null || order.getUser().getId().equals(dto.getUserId()))
                .filter(order -> dto.getProductId() == null || order.getOrderItems().stream()
                        .anyMatch(item -> item.getProduct().getProductId().equals(dto.getProductId())))
                .toList();
    }

    @Transactional
    public void deleteOrder(Long orderId) {
        if(!orderRepository.existsById(orderId)) {
            throw new IllegalArgumentException("존재하지 않는 주문입니다.");
        }

        orderRepository.deleteById(orderId);
    }
}
