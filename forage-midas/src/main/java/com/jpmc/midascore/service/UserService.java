package com.jpmc.midascore.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jpmc.midascore.entity.UserRecord;
import com.jpmc.midascore.repository.UserRecordRepository;
 
@Service
public class UserService {
    private final UserRecordRepository userRepository;

    public UserService(UserRecordRepository userRecordRepository) {
        this.userRepository = userRecordRepository;
    }

    public List<UserRecord> getBalanceByName(String name) {
        // Correct: .map() is called on Optional<UserRecord>, not UserRecord
        return userRepository.findByName(name);
                
    }
}