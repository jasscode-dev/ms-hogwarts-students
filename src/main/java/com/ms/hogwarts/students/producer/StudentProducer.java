package com.ms.hogwarts.students.producer;

import com.ms.hogwarts.students.dtos.StudentDto;
import com.ms.hogwarts.students.models.StudentModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class StudentProducer {
    final RabbitTemplate rabbitTemplate;


    @Value(value="${broker.queue.generate-house}")
    private String routingKey;

    public StudentProducer(RabbitTemplate rabbitTemplate ) {
        this.rabbitTemplate = rabbitTemplate;

    }

    public void publishMessage(StudentModel studentModel) {
        var generateHouse  = new StudentDto(
                studentModel.getUserId(),
                studentModel.getName(),
                studentModel.getEmail(),
                studentModel.getAnswers()
        );
        rabbitTemplate.convertAndSend("",routingKey, generateHouse);
    }
}
