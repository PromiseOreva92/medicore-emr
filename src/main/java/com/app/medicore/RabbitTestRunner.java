package com.app.medicore;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RabbitTestRunner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void run(String... args) {

        rabbitTemplate.convertAndSend(
                "appointment.exchange",
                "appointment.notification",
                "RabbitMQ is working!"
        );

        System.out.println("Message sent successfully");
    }
}