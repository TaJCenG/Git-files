package org.tajceng.taskmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.config.Task;
import org.tajceng.taskmanagement.entity.User;

import java.util.List;

//Task Repository
public interface TaskRepository<TaskStatus> extends JpaRepository<Task, Long> {
    List<Task> findByStatus(TaskStatus status);
    List<Task> findByAssignedTo(User user);
}