package org.tajceng.taskmanagement.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final StakeholderRepository stakeholderRepository;
    private final NotificationService notificationService;

    @Autowired
    public TaskService(TaskRepository taskRepository,
                       UserRepository userRepository,
                       StakeholderRepository stakeholderRepository,
                       NotificationService notificationService) {
        // Constructor injection
    }

    public TaskResponse createTask(TaskRequest request) {
        // Validate and resolve relationships
        User createdBy = userRepository.findById(request.getCreatedById())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        User assignedTo = Optional.ofNullable(request.getAssignedToId())
                .flatMap(userRepository::findById)
                .orElse(null);

        Stakeholder stakeholder = Optional.ofNullable(request.getStakeholderId())
                .flatMap(stakeholderRepository::findById)
                .orElse(null);

        // Create entity
        Task task = Task.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .dueDate(request.getDueDate())
                .priority(request.getPriority())
                .status(TaskStatus.PENDING)
                .source(request.getSource())
                .createdBy(createdBy)
                .assignedTo(assignedTo)
                .stakeholder(stakeholder)
                .build();

        // Save and trigger notifications
        Task savedTask = taskRepository.save(task);
        notificationService.notifyTaskAssignment(savedTask);

        return mapToResponse(savedTask);
    }

    public TaskResponse updateTaskStatus(Long taskId, TaskStatus status) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException("Task not found"));

        task.setStatus(status);
        Task updatedTask = taskRepository.save(task);

        return mapToResponse(updatedTask);
    }

    private TaskResponse mapToResponse(Task task) {
        return TaskResponse.builder()
                .id(task.getId())
                .title(task.getTitle())
                .status(task.getStatus())
                .dueDate(task.getDueDate())
                .assignedTo(mapUserToDto(task.getAssignedTo()))
                .stakeholder(mapStakeholderToDto(task.getStakeholder()))
                .build();
    }
}