package com.ms.hogwarts.students.services;

import com.ms.hogwarts.students.models.StudentModel;
import com.ms.hogwarts.students.repositories.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Transactional
    public StudentModel save(StudentModel studentModel) {
        studentModel = studentRepository.save(studentModel);
        return studentModel;


    }
}
