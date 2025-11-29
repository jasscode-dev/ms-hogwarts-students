package com.ms.hogwarts.students.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Entity
@Table(name="TB_OPTION_QUESTION")
@Getter
@Setter
public class OptionQuestionModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="question_id")
    private QuestionModel question;
    @Column(length = 1,nullable = false)
    private String key;
    @Column(nullable = false)
    private String label;
    @Column(nullable = false)
    private String meaning;

}
