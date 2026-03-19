//package com.taj.kafka.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//import com.taj.kafka.dto.User;
//
//@Service
//public class UserProducerService {
//
//	@Autowired
//	private KafkaTemplate<String, User> kafkaTemplate;
//	
//	
//	public void sendUserData( User user) {
//		
//	//kafkaTemplate.send("Syf", user.getName(), user);
//}
//}