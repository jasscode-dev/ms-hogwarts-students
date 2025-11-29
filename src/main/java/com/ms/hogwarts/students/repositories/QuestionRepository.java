package com.ms.hogwarts.students.repositories;

import com.ms.hogwarts.students.models.QuestionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionModel, Long>   {
    @Query("SELECT q FROM QuestionModel q LEFT JOIN FETCH q.options ORDER BY q.question_order ASC")
    List<QuestionModel> findAllWithOptionsOrdered();
}
