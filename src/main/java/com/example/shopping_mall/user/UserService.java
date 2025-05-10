package com.example.shopping_mall.user;

import java.util.List;
import com.example.shopping_mall.user.dto.UserRequest;
import com.example.shopping_mall.user.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UserService {

    private final UserRepository userRepository;

    public List<UserResponse> getUsers() {
        return UserResponse.fromList(
                userRepository.findAll()
        );
    }

    public UserResponse createUser(UserRequest dto) {
        User user = User.builder()
                .id(dto.getId())
                .email(dto.getEmail())
                .username(dto.getUsername())
                .build();
        return UserResponse.fromEntity(userRepository.save(user));
    }
}
