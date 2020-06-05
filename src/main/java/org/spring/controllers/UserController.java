package org.spring.controllers;

import java.util.List;
import java.util.stream.Collectors;
import org.spring.dto.UserResponseDto;
import org.spring.models.User;
import org.spring.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/inject")
    public String injectData() {
        userService.add(new User("nick@gmail.com", "1111"));
        userService.add(new User("bob@gmail.com", "2222"));
        userService.add(new User("alice@gmail.com", "3333"));
        userService.add(new User("john@gmail.com", "4444"));
        return "Data were injected";
    }

    @GetMapping("/{userId}")
    public UserResponseDto get(@PathVariable Long userId) {
        return getUserDto(userService.get(userId));
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        List<User> users = userService.listUsers();
        return users.stream()
                .map(this::getUserDto)
                .collect(Collectors.toList());
    }

    private UserResponseDto getUserDto(User user) {
        var userResponseDto = new UserResponseDto();
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setPassword(user.getPassword());
        return userResponseDto;
    }
}
