package com.app.medicore.service.impl;

import com.app.medicore.config.RabbitMQConfig;
import com.app.medicore.dto
        .AppointmentNotificationEvent;
import com.app.medicore.service
        .NotificationProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core
        .RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationProducerImpl implements NotificationProducer {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void publishAppointmentNotification(AppointmentNotificationEvent event) {

        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE,RabbitMQConfig.ROUTING_KEY,event);
    }
}