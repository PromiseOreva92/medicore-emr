package com.app.medicore.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE =
            "appointment.exchange";

    public static final String QUEUE =
            "appointment.notification.queue";

    public static final String ROUTING_KEY =
            "appointment.notification";

    @Bean
    public Queue appointmentQueue() {
        return QueueBuilder
                .durable(QUEUE)
                .build();
    }

    @Bean
    public TopicExchange appointmentExchange() {
        return ExchangeBuilder
                .topicExchange(EXCHANGE)
                .durable(true)
                .build();
    }

    @Bean
    public Binding appointmentBinding(
            Queue appointmentQueue,
            TopicExchange appointmentExchange) {

        return BindingBuilder
                .bind(appointmentQueue)
                .to(appointmentExchange)
                .with(ROUTING_KEY);
    }
}