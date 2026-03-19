package com.jpmc.midascore;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;

import com.jpmc.midascore.entity.UserRecord;
import com.jpmc.midascore.repository.UserRecordRepository;

@SpringBootTest
@DirtiesContext
@EmbeddedKafka(partitions = 1, brokerProperties = {"listeners=PLAINTEXT://localhost:9092", "port=9092"})
public class TaskThreeTests {
    static final Logger logger = LoggerFactory.getLogger(TaskThreeTests.class);

    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private UserPopulator userPopulator;

    @Autowired
    private FileLoader fileLoader;
    @Autowired
    private UserRecordRepository userRepository;
    
    @Test
    void task_three_verifier() throws InterruptedException {
        userPopulator.populate();
        String[] transactionLines = fileLoader.loadStrings("/test_data/mnbvcxz.vbnm");
        for (String transactionLine : transactionLines) {
            kafkaProducer.send(transactionLine);
        }
     // In TaskThreeTests.java
        List<UserRecord> waldorfOpt = userRepository.findByName("waldorf");
        if (!waldorfOpt.isEmpty()) {
            UserRecord waldorf = waldorfOpt.get(9);
            float balance = waldorf.getBalance();
            logger.info("Waldorf's balance: {}", balance);
        } else {
            logger.error("User 'waldorf' not found");
        }
       
        logger.info("-------------------------------------{}");
        logger.info("-------------------------------------{}");
        logger.info("----------------------------------------------------------");
        logger.info("use your debugger to find out what waldorf's balance is after all transactions are processed");
        logger.info("kill this test once you find the answer");
        while (true) {
            Thread.sleep(2000);
            List<UserRecord> waldorfOpt1 = userRepository.findByName("waldorf");
            if (!waldorfOpt1.isEmpty()) {
                UserRecord waldorf = waldorfOpt1.get(0);
                float balance = waldorf.getBalance();
                logger.info("Waldorf's balance: {}", balance);
            } else {
                logger.error("User 'waldorf' not found");
            }
           logger.info("---- {}");
        }
    }
}
