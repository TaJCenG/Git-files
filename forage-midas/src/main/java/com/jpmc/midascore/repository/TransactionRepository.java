package com.jpmc.midascore.repository;

import com.jpmc.midascore.foundation.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}