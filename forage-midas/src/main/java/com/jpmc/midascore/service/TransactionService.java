package com.jpmc.midascore.service;


import com.jpmc.midascore.entity.Incentive;
import com.jpmc.midascore.entity.UserRecord;
import com.jpmc.midascore.foundation.Transaction;
import com.jpmc.midascore.repository.TransactionRepository;
import com.jpmc.midascore.repository.UserRecordRepository;

import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TransactionService {
    private final TransactionRepository repository;
    private final UserRecordRepository userRepo;
    public TransactionService(TransactionRepository repository, UserRecordRepository userRepo) {
        this.repository = repository;
        this.userRepo = userRepo;
		this.restTemplate = new RestTemplate();
    }

    public Transaction saveTransaction(Transaction transaction) {
        return repository.save(transaction);
    }
    
    private final RestTemplate restTemplate;

    @Value("http://localhost:8080/incentive")
    private String incentiveUrl;

    @Transactional
    public void processTransaction(Transaction transaction) {
        // Validate users
    	        // Use IDs instead of UserRecord objects
    	        UserRecord sender = userRepo.findById(transaction.getSender().getId())
    	                                  .orElseThrow();
    	        UserRecord recipient = userRepo.findById(transaction.getRecipient().getId())
    	                                    .orElseThrow();
        if (sender.getBalance() >= transaction.getAmount()) {
            // Deduct from sender
            sender.setBalance(sender.getBalance() - transaction.getAmount());
            userRepo.save(sender);

            // Get incentive
            Incentive incentive = restTemplate.postForObject(
                incentiveUrl, 
                transaction, 
                Incentive.class
            );
            float incentiveAmount = incentive != null ? incentive.getAmount() : 0;
            ((UserRecord) userRepo.findByName("wilbur")).getBalance(); 
            // Credit recipient
            recipient.setBalance(recipient.getBalance() + transaction.getAmount() + incentiveAmount);
            userRepo.save(recipient);

            // Record transaction
            transaction.setIncentive(incentiveAmount);
            repository.save(transaction);
        }
    }
    
    
    
    
    
    
    
    
    
    
// 
//    
//
//    public void processTransaction(UserRecord transaction) throws Exception {
//        List<UserRecord> senders = userRepo.findByName(transaction.getName());
//        if (senders.isEmpty()) {
//            throw new Exception(transaction.getName());
//        }
//        UserRecord sender = senders.get(0); // Take first match
//
//        // Repeat for recipient
//        List<UserRecord> recipients = userRepo.findByName(transaction.getName());
//        UserRecord recipient = recipients.isEmpty() 
//            ? null 
//            : recipients.get(0);
//
//        // ... validation and balance update ...
//    }
    
    
    
}