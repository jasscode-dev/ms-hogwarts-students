package com.ms.hogwarts.students.repositories;

import com.ms.hogwarts.students.models.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, UUID> {
}
