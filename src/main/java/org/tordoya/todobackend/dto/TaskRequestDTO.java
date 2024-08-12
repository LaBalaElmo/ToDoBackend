package org.tordoya.todobackend.dto;

public record TaskRequestDTO(
        Long id,
        String title,
        String description,
        Long statusId
) {
}
