package com.taj.kafka.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

public class kafkaproducer {
	public static void main (String [] args) {
		Properties props = new Properties();
		props.setProperty("bootstrap.servers", "localhost:9092");
		props.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.setProperty("value.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
		props.setProperty(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true");
		props.setProperty(ProducerConfig.ACKS_CONFIG, "all");
		props.setProperty(ProducerConfig.RETRIES_CONFIG, Integer.toString(3));
		props.setProperty(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, "5");
		props.setProperty(ProducerConfig.DELIVERY_TIMEOUT_MS_CONFIG, "100000");
		props.setProperty(ProducerConfig.RETRY_BACKOFF_MAX_MS_CONFIG, "1000");
		props.setProperty(ProducerConfig.RETRY_BACKOFF_MS_CONFIG, "1000");
		
		KafkaProducer<String, Integer> producer = new KafkaProducer<String, Integer>(props);
		ProducerRecord<String, Integer> record = new ProducerRecord<>("", "TajCheng", 23);
		try {
			producer.send(record, new OrderCallback()); //AsySynchronous
			
//			RecordMetadata rmd = producer.send(record, new OrderCallback).get(); //Synchronous
//			System.out.println(rmd.partition());
//			System.out.println(rmd.partition());
			System.out.println("TajCheng");
			System.out.println(record);
		//producer.send(record);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			producer.close();
		}
	}

}
