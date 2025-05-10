package com.example.shopping_mall.user.dto;

import lombok.Data;

@Data
public class UserRequest {
    private Long id;

    private String email;
    private String password;
    private String username;
}
