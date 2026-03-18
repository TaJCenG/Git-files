package com.sprBoot.user.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.sprboot.common.events.UserEvent;
@Service
public class UserEventProducer {
    private static final String TOPIC = "user-created";
    private final KafkaTemplate<String, UserEvent> kafkaTemplate;

    public UserEventProducer(KafkaTemplate<String, UserEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendUserCreatedEvent(Long userId, String email) {
        UserEvent event = new UserEvent();
        event.setUserId(userId);
        event.setEmail(email);
        kafkaTemplate.send(TOPIC, event);
    }
}