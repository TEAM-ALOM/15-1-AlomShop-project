package com.example.shopping_mall.user.dto;

import com.example.shopping_mall.user.User;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserResponse {

    private Long id;
    private String username;
    private String email;


    public static UserResponse fromEntity(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }
    public static List<UserResponse> fromList(List<User> users) {
        List<UserResponse> list = new ArrayList<>();

        for(User user : users)
            list.add(fromEntity(user));

        return list;
    }
}