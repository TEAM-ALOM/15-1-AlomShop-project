package com.example.shopping_mall.user;



import com.example.shopping_mall.user.dto.UserRequest;
import com.example.shopping_mall.user.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/api/user")
    public List<UserResponse> getUsers() {
        return userService.getUsers();
    }
    @PostMapping("/api/user")
    public UserResponse createUser(@RequestBody UserRequest dto){
        return userService.createUser(dto);
    }
}
