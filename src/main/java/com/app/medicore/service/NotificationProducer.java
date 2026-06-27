package com.app.medicore.service;

import com.app.medicore.dto
        .AppointmentNotificationEvent;

public interface NotificationProducer {
    void publishAppointmentNotification(AppointmentNotificationEvent event);
}