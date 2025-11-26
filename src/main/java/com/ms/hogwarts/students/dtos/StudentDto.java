package com.ms.hogwarts.students.dtos;

import java.util.List;
import java.util.UUID;

public record  StudentDto(
        UUID userId,
        String email,
        String name,
        List<String> answers
) {

}
