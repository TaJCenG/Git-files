package org.tajceng.taskmanagementapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tajceng.taskmanagementapp.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}

