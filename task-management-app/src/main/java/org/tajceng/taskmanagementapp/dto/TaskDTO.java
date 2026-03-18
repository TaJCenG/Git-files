package org.tajceng.taskmanagementapp.dto;

import lombok.*;
import org.tajceng.taskmanagementapp.entity.Task.Priority;
import org.tajceng.taskmanagementapp.entity.Task.Status;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDTO {
    private Long userId;
    private String title;
    private String description;
    private LocalDate dueDate;
    private Priority priority;
    public Status status;
}
