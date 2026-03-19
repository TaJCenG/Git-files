package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyKafkaProducer {
	private static final Logger LOGGER = LoggerFactory.getLogger(MyKafkaProducer.class);
    private final KafkaTemplate<String, String> kafkaTemplate;

    public MyKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    @PostMapping("/send")
    public void sendMessage(@RequestBody String message) {
    	// message = "hi bro How r u";
    	 LOGGER.info("Sending message: {}", message);
        kafkaTemplate.send("my-topic", message);
    }
}
