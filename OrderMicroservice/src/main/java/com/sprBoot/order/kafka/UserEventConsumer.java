package com.sprBoot.order.kafka;

import java.util.HashSet;
import java.util.Set;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.sprboot.common.events.UserEvent;
@Service
public class UserEventConsumer {
    // Simple in-memory cache
    private final Set<Long> validUserIds = new HashSet<>();

    @KafkaListener(topics = "user-created", groupId = "order-service-group")
    public void consumeUserEvent(UserEvent event) {
        validUserIds.add(event.getUserId());
        System.out.println("Received valid user: " + event.getUserId());
    }

    public boolean isValidUser(Long userId) {
        return validUserIds.contains(userId);
    }
}