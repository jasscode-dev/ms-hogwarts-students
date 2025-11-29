package com.ms.hogwarts.students.dtos;


import java.util.List;
import java.util.UUID;

public record SortingRequestDto(
        UUID id,
        List<String> answers
)
{}
