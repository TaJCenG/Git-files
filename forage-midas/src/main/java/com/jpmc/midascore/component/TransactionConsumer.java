package com.jpmc.midascore.component;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.jpmc.midascore.foundation.Transaction;

@Component
public class TransactionConsumer {
    
    @KafkaListener(topics = "${general.kafka-topic}") // Use configured topic
    public void consumeTransaction(Transaction transaction) {
        // For debugging purposes only
        System.out.println("Received transaction amount: " + transaction.getAmount());
    }
}