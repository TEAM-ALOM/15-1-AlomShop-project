package com.example.shopping_mall.order;


import com.example.shopping_mall.order.dto.OrderRequestDto;
import com.example.shopping_mall.order.dto.OrderSearchRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order/")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderRequestDto dto) {
        orderService.createOrder(dto.getUserId(), dto.getProductId(),dto.getOrderDate(),dto.getQuantity());
        return ResponseEntity.ok("주문이 완료되었습니다.");
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrders(@ModelAttribute OrderSearchRequestDto dto){
        List<Order> orders = orderService.findOrder(dto);
        return ResponseEntity.ok(orders);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteOrder(@RequestParam Long orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.ok("주문이 삭제되었습니다.");
    }
}
