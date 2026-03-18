package org.tajceng.taskmanagementapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tajceng.taskmanagementapp.entity.Task;
import org.tajceng.taskmanagementapp.entity.User;

import java.time.LocalDate;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUser(User user);
    List<Task> findByDueDate(LocalDate dueDate);
}

