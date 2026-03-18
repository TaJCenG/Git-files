package org.tajceng.taskmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tajceng.taskmanagement.entity.User;

import java.util.Optional;

// User Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}


// Similarly for Stakeholder, Comment, Notification, Team