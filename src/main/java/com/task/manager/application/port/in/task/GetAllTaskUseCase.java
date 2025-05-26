package com.task.manager.application.port.in.task;

import com.task.manager.domain.model.TaskDTO;

import java.util.List;

/**
 * The interface Get all task use case.
 */
public interface GetAllTaskUseCase {

    /**
     * Gets all tasks.
     *
     * @return the all tasks
     */
    List<TaskDTO> getAllTasks();
}
