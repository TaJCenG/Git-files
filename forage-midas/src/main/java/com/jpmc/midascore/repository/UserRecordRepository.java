package com.jpmc.midascore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jpmc.midascore.entity.UserRecord;

public interface UserRecordRepository extends JpaRepository<UserRecord, Long> {
	List<UserRecord> findByName(String name);
	Optional<UserRecord> findById(UserRecord userRecord);
}
