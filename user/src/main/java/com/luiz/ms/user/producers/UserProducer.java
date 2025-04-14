package com.luiz.ms.user.producers;

import com.luiz.ms.user.dtos.EmailDTO;
import com.luiz.ms.user.models.UserModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    final RabbitTemplate rabbitTemplate;

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public UserProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishMessageEmail(UserModel userModel){
        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setUserId(userModel.getUserId());
        emailDTO.setEmailTo(userModel.getEmail());
        emailDTO.setSubject("Registration successfully completed!");
        emailDTO.setText(userModel.getName() + " welcome! We appreciate your registration, enjoy all our platform features now!");

        rabbitTemplate.convertAndSend("", routingKey, emailDTO);
    }
}
