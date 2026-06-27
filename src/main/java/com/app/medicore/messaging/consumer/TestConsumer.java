package com.app.medicore.messaging.consumer;

import com.app.medicore.config.RabbitMQConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TestConsumer {

    @RabbitListener(
            queues = RabbitMQConfig.QUEUE
    )
    public void receive(String message) {

        log.info(
                "Received Message: {}",
                message
        );
    }
}
