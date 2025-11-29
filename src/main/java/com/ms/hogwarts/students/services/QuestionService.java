package com.ms.hogwarts.students.services;

import com.ms.hogwarts.students.dtos.OptionQuestionResponseDto;
import com.ms.hogwarts.students.dtos.QuestionResponseDto;
import com.ms.hogwarts.students.models.OptionQuestionModel;
import com.ms.hogwarts.students.models.QuestionModel;
import com.ms.hogwarts.students.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public List<QuestionResponseDto> getAllQuestions() {
        return  questionRepository.findAllWithOptionsOrdered()
                .stream().map(q->{
                    var options = q.getOptions().stream()
                            .map(o->
                                    new OptionQuestionResponseDto(
                                            o.getId(),
                                            o.getKey(),
                                            o.getLabel(),
                                            o.getMeaning()
                                    )
                            ).toList();
                    return new QuestionResponseDto(
                            q.getId(),
                            q.getQuestion_text(),
                            q.getQuestion_order(),
                            options
                    );
                })
                .toList();
    }
    public List <OptionQuestionModel> getSelectedAnswer(List<String> keys) {
        List<QuestionModel> questions = questionRepository.findAllWithOptionsOrdered();
        List<OptionQuestionModel> selectedOptions = new ArrayList<>();


        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            QuestionModel question = questions.get(i);

            question.getOptions().stream()
                    .filter(o -> o.getKey().equalsIgnoreCase(key))
                    .findFirst()
                    .ifPresent(selectedOptions::add);

        }

        return selectedOptions;



    }
}
