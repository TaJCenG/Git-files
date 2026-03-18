package com.sprBoot.user.service;


import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.sprBoot.user.dao.User;

@Service
public class UserEventPublisher<kafkaTemplate> {
    private static final String TOPIC_USER_CREATED = "user-created";
    private final KafkaTemplate<String, User> kafkaTemplate;

    public UserEventPublisher(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishUserCreatedEvent(User user) {
    	kafkaTemplate.send(TOPIC_USER_CREATED, user);
    }
}