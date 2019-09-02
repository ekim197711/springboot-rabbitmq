package com.example.demorabbitmq.rabbitmq.producer;

import com.example.demorabbitmq.rabbitmq.ConfigureRabbitMq;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMessageController {

    private final RabbitTemplate rabbitTemplate;

    public SendMessageController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String themessage){
        rabbitTemplate.convertAndSend(ConfigureRabbitMq.EXCHANGE_NAME,
                "mike.springmessages", themessage);
        return "We have sent a message! :" + themessage;
    }
}
