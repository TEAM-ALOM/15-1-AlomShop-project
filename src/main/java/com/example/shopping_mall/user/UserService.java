package com.example.shopping_mall.user;

import java.util.List;

import com.example.shopping_mall.cart.Cart;
import com.example.shopping_mall.cart.CartRepository;
import com.example.shopping_mall.user.dto.UserRequest;
import com.example.shopping_mall.user.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CartRepository cartRepository;

    public List<UserResponse> getUsers() {
        return UserResponse.fromList(userRepository.findAll());
    }

    public UserResponse createUser(UserRequest dto) {
        User user = User.builder()
                .email(dto.getEmail())
                .username(dto.getUsername())
                .password(dto.getPassword())
                .build();

        // 1. 유저 저장
        User savedUser = userRepository.save(user);

        // 2. 카트 자동 생성 후 저장
        Cart cart = Cart.builder()
                .user(savedUser)
                .build();
        cartRepository.save(cart);

        return UserResponse.fromEntity(savedUser);
    }
}