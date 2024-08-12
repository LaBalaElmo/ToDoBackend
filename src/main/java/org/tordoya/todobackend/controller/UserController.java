package org.tordoya.todobackend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tordoya.todobackend.domain.User;
import org.tordoya.todobackend.dto.UserRegisterRequestDTO;
import org.tordoya.todobackend.dto.UserResponseDTO;
import org.tordoya.todobackend.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserResponseDTO registerUser(@RequestBody UserRegisterRequestDTO user) {
        return userService.save(user);
    }
}
