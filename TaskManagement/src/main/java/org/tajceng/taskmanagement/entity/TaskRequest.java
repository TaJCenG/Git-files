package org.tajceng.taskmanagement.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskRequest {
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private TaskPriority priority;
    private Long assignedTo;
    private Long teamId;
    private Long stakeholderId;
}