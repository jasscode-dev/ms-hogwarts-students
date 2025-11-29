package com.ms.hogwarts.students.dtos;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ApiError(int status,
                       String error,
                       String message,
                       String path,
                       LocalDateTime timestamp) {
}
