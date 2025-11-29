package com.ms.hogwarts.students.dtos;

import java.util.List;

public record QuestionResponseDto(Long id,
                                  String questionText,
                                  Integer questionOrder,
                                  List<OptionQuestionResponseDto> options) {
}
