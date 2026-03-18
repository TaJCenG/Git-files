package org.tajceng.taskmanagementapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tajceng.taskmanagementapp.dto.TaskDTO;
import org.tajceng.taskmanagementapp.entity.Task;
import org.tajceng.taskmanagementapp.entity.User;
import org.tajceng.taskmanagementapp.service.TaskService;
import org.tajceng.taskmanagementapp.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @PostMapping
    public Task createTask(@RequestBody TaskDTO taskDTO) {
        User user = userService.getUserById(taskDTO.getUserId()).orElseThrow();
        Task task = Task.builder()
                .user(user)
                .title(taskDTO.getTitle())
                .description(taskDTO.getDescription())
                .dueDate(taskDTO.getDueDate())
                .priority(taskDTO.getPriority())
                .status(taskDTO.getStatus())
                .build();
        return taskService.createTask(task);
    }

    @GetMapping("/user/{userId}")
    public List<Task> getTasksByUser(@PathVariable Long userId) {
        User user = userService.getUserById(userId).orElseThrow();
        return taskService.getTasksByUser(user);
    }

    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
    }
}
