package com.ms.hogwarts.students.services;

import com.ms.hogwarts.students.dtos.SortingRequestDto;
import com.ms.hogwarts.students.dtos.SortingResponseDto;
import com.ms.hogwarts.students.models.StudentModel;
import com.ms.hogwarts.students.repositories.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class StudentService {
    final StudentRepository studentRepository;
    final WebClient webClient;

    @Value("${services.sorting-hat.url}")
    private String sortingHatUrl;


    public StudentService(StudentRepository studentRepository, WebClient webClient, WebClient webClient1) {
        this.studentRepository = studentRepository;
        this.webClient = webClient1;
    }


    @Transactional
    public StudentModel save(StudentModel studentModel) {
        studentModel = studentRepository.save(studentModel);

        return studentModel;


    }
    public Mono<SortingResponseDto> generateHouseForStudent( List<String> answers) {

        return webClient.post()
                .uri(sortingHatUrl + "/sorting")
                .bodyValue(answers)
                .retrieve()
                .bodyToMono(SortingResponseDto.class);
    }
}
