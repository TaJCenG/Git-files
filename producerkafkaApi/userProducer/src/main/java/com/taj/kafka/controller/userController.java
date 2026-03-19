package com.taj.kafka.controller;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taj.kafka.dto.User;
//import com.taj.kafka.service.UserProducerService;

@RestController
@RequestMapping(value="/us")
public class userController {
	
//	@Autowired
//	private UserProducerService service;
@Autowired
@Qualifier("dallasKafkaTemplate")
private KafkaTemplate<String, User> dallasKafkaTemplate;
	

	private final Logger log = LoggerFactory.getLogger(userController.class);
	
	@PostMapping("/post")
	public void  sendUserData(@RequestBody User user) throws InterruptedException, ExecutionException, TimeoutException {
		String Message = " Hi I'm in producer service";
	//	service.sendUserData(user);
		log.info("Message" + Message);
		SendResult<String, User> kafkaResponeResult = dallasKafkaTemplate.send("TruckTopic", user).get(10000, TimeUnit.MILLISECONDS);
		log.info("kafkaResponeResult: {}", kafkaResponeResult);
		//dallasKafkaTemplate.send("Syf", user);
		log.info("Message" + Message);
		
//		log.info("User Name is : " + user.getName());
//		log.info("User age is : " + user.getAge());
//		return user;
	}
}
