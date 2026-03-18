package org.tajceng.taskmanagement.entity;

import lombok.Data;

@Data
public class TaskResponse {
    private Long id;
    private String title;
    private TaskStatus status;
    private UserResponse assignedTo;
    private StakeholderResponse stakeholder;
    // ... other fields
}