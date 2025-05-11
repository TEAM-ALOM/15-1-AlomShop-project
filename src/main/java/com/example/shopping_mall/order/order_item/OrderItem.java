package com.example.shopping_mall.order.order_item;


import com.example.shopping_mall.Product.Product;
import com.example.shopping_mall.order.Order;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;

    private int quantity;

    @ManyToOne
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
