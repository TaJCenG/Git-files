package com.taj.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taj.kafka.dto.User;

@Configuration
@EnableKafka
public class kafkaproducer {
	
	@Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaProperties kafkaProperties;

    @Bean
    public ProducerFactory<String, User> userProducerFactory() {
        Map<String, Object> configProps = new HashMap<>(kafkaProperties.buildProducerProperties());
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean(name = "dallasKafkaTemplate")
    public KafkaTemplate<String, User> dallasKafkaTemplate() {
        return new KafkaTemplate<>(userProducerFactory());
    }

    @Bean
    public Map<String, Object> dallasProducerConfig() {
        Map<String, Object> props = new HashMap<>(kafkaProperties.buildProducerProperties()); // Use KafkaProperties

        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, org.springframework.kafka.support.serializer.JsonSerializer.class);
        return props;
    }

	/*
	 * @Autowired private ObjectMapper objectMapper;
	 * 
	 * @Autowired private KafkaProperties kafkaProperties;
	 * 
	 * @Bean public ProducerFactory<String, User> userProducerFactory() {
	 * Map<String, Object> configProps = new
	 * HashMap<>(kafkaProperties.buildProducerProperties());
	 * configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
	 * StringSerializer.class);
	 * configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, new
	 * JsonSerializer<>(objectMapper)); return new
	 * DefaultKafkaProducerFactory<>(configProps); }
	 * 
	 * @Bean(name = "dallasKafkaTemplate") public KafkaTemplate<String, User>
	 * dallasKafkaTemplate() { return new KafkaTemplate<>(userProducerFactory()); }
	 * 
	 * @Bean public Map<String, Object> dallasProducerConfig ()throws Exception{
	 * Map<String, Object> props = new HashMap<>();
	 * 
	 * props.put("bootstrap.servers", "localhost:9092"); props.put("key.serializer",
	 * StringSerializer.class); // Use the class props.put("value.serializer",
	 * org.springframework.kafka.support.serializer.JsonSerializer.class); // Use
	 * the class props.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true");
	 * props.put(ProducerConfig.ACKS_CONFIG, "all");
	 * props.put(ProducerConfig.RETRIES_CONFIG, Integer.toString(3));
	 * props.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, "5");
	 * props.put(ProducerConfig.DELIVERY_TIMEOUT_MS_CONFIG, "20000");
	 * props.put(ProducerConfig.RETRY_BACKOFF_MAX_MS_CONFIG, "2000");
	 * props.put(ProducerConfig.RETRY_BACKOFF_MS_CONFIG, "1000");
	 * props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
	 * StringSerializer.class); // Redundant but harmless
	 * props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
	 * org.springframework.kafka.support.serializer.JsonSerializer.class); //
	 * Redundant but harmless
	 * props.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG,"10000" ); return props; }
	 * 
	 * 
	 * @Bean public Map<String, Object> dallasProducerConfig ()throws Exception{
	 * 
	 * 
	 * //Properties props = new Properties(); Map<String, Object> props = new
	 * HashMap<>();
	 * 
	 * props.put("bootstrap.servers", "localhost:9092"); props.put("key.serializer",
	 * "org.apache.kafka.common.serialization.StringSerializer");
	 * props.put("value.serializer",
	 * "org.apache.kafka.common.serialization.IntegerSerializer");
	 * props.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true");
	 * props.put(ProducerConfig.ACKS_CONFIG, "all");
	 * props.put(ProducerConfig.RETRIES_CONFIG, Integer.toString(3));
	 * props.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, "5");
	 * props.put(ProducerConfig.DELIVERY_TIMEOUT_MS_CONFIG, "20000");
	 * props.put(ProducerConfig.RETRY_BACKOFF_MAX_MS_CONFIG, "2000");
	 * props.put(ProducerConfig.RETRY_BACKOFF_MS_CONFIG, "1000");
	 * props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
	 * StringSerializer.class);
	 * props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
	 * JsonSerializer.class);
	 * props.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG,"10000" ); return props; }
	 * 
	 * @Bean public ProducerFactory<String, User> dallasProducerFactory() throws
	 * Exception { return new DefaultKafkaProducerFactory<>(dallasProducerConfig());
	 * }
	 * 
	 * @Bean(name = "dallasKafkaTemplate") public KafkaTemplate<String, User>
	 * kafkaTemplate() throws Exception { return new
	 * KafkaTemplate<>(dallasProducerFactory()); }
	 */

}