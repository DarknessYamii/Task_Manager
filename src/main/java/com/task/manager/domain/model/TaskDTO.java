package com.task.manager.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The type Task dto.
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {

    private long id;

    private String taskName;

    private String taskDescription;

    private String taskStatus;

}
