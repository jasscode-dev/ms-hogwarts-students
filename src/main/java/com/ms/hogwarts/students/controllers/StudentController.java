package com.ms.hogwarts.students.controllers;

import com.ms.hogwarts.students.dtos.StudentRequestDto;
import com.ms.hogwarts.students.models.StudentModel;
import com.ms.hogwarts.students.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
    final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping
    public ResponseEntity<StudentModel> saveUser(@RequestBody @Valid StudentRequestDto studentRequesrDto) {
        var studentModel = new StudentModel();
        BeanUtils.copyProperties(studentRequesrDto, studentModel);
        var userSave = studentService.save(studentModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userSave);
    }

}
