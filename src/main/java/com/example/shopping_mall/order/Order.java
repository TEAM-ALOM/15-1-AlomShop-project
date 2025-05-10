package com.example.shopping_mall.order;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

   // @ManyToOne
   // private User user;

    private LocalDate orderDate;

   // @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
   // private List<OrderItem> orderItems = new ArrayList<>();


}
