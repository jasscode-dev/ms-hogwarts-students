package com.ms.hogwarts.students.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="TB_QUESTION")
@Getter @Setter
public class QuestionModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(nullable=false)
    private String question_text;
    @Column(nullable=false)
    private Integer question_order;
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<OptionQuestionModel> options = new ArrayList<>();
}
