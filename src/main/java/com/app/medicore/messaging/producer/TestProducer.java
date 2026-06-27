package com.app.medicore.messaging.producer;

import com.app.medicore.config.RabbitMQConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestProducer {

    private final RabbitTemplate rabbitTemplate;

    public void send(String message) {

        rabbitTemplate.convertAndSend(
                RabbitMQConfig.QUEUE,
                message
        );
    }
}
