package com.task.manager.application.port.in.task;

import com.task.manager.domain.model.TaskDTO;

/**
 * The interface Create task use case.
 */
public interface CreateTaskUseCase {

    /**
     * Create task task dto.
     *
     * @param task the task
     * @return the task dto
     */
    TaskDTO createTask(TaskDTO task);
}
