package com.ms.hogwarts.students.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="TB_STUDENTS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID userId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    private List<String> answers = new ArrayList<>();

}
