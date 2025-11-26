package com.ms.hogwarts.students.dtos;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

public record StudentRequestDto(
        @NotBlank(message = "Nome é obrigatorio")
        String name,

        @Email(message = "Digite um email válido")
        @NotBlank(message = "Email é obrigatorio")
        String email,

        @NotNull(message = "As respostas são obrigatórias")
        List<@Size(min = 1, max = 1, message = "Cada resposta deve ter exatamente 1 caractere") String> answers
) {}