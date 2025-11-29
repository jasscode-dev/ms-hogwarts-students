package com.ms.hogwarts.students.dtos;


import java.util.List;

public record SortingRequestDto(
        String name ,
        List<String> answers
)
{}
