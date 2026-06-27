package com.app.medicore.messaging;

import com.app.medicore.config
        .RabbitMQConfig;
import com.app.medicore.dto
        .AppointmentNotificationEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation
        .RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NotificationConsumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void receiveAppointmentNotification(AppointmentNotificationEvent event) {
        log.info("Appointment notification received.");

        log.info("Patient: {}",event.getPatientName());

        log.info("Doctor: {}",event.getDoctorName());

        log.info("Date: {}",event.getAppointmentDate());

        log.info("Sending SMS to {}",event.getPatientPhone());
    }
}