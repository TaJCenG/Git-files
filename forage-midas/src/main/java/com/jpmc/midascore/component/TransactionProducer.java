//package com.jpmc.midascore.component;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Component;
//
//import com.jpmc.midascore.foundation.Transaction;
//
//@Component
//public class TransactionProducer {
//    private static final Logger logger = LoggerFactory.getLogger(TransactionProducer.class);
//    
//    @Value("${general.kafka-topic}")
//    private String topicName;
//
//    private final KafkaTemplate<String, Transaction> kafkaTemplate;
//
//    public TransactionProducer(KafkaTemplate<String, Transaction> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
////a
//    public void sendTransaction(Transaction transaction) {
//        kafkaTemplate.send(topicName, transaction.getSenderId(), transaction);
//        logger.info("Produced transaction: {}", transaction.getSenderId());
//    }
//}