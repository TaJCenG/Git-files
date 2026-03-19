package com.taj.kafka.servie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.taj.kafka.dto.User;

@Service
public class UserConsumerService {
	private final Logger log = LoggerFactory.getLogger(UserConsumerService.class);
	@KafkaListener(topics = { "TruckTopic"})
	public void consumerUserData(User user) {
		log.info("User Name is : {} :: User Age {}" , user.getName(), user.getAge());
		
		log.info("User Name is : " + user.getName());
		log.info("User age is : " + user.getAge());
		
	}
}
