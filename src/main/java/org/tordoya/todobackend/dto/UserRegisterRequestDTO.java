package org.tordoya.todobackend.dto;

public record UserRegisterRequestDTO(
    String username,
    String email,
    String password
) {
}
