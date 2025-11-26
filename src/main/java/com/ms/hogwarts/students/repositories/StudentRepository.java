package com.ms.hogwarts.students.repositories;

import com.ms.hogwarts.students.models.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentRepository extends JpaRepository<StudentModel, UUID> {
}
