package com.ms.hogwarts.students.services;

import com.ms.hogwarts.students.models.StudentModel;
import com.ms.hogwarts.students.producer.StudentProducer;
import com.ms.hogwarts.students.repositories.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    final StudentRepository studentRepository;
    final StudentProducer studentProducer;

    public StudentService(StudentRepository studentRepository, StudentProducer studentProducer) {
        this.studentRepository = studentRepository;
        this.studentProducer = studentProducer;
    }


    @Transactional
    public StudentModel save(StudentModel studentModel) {
        studentModel = studentRepository.save(studentModel);
        studentProducer.publishMessage(studentModel);
        return studentModel;


    }
}
