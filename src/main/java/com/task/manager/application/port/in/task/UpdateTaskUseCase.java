package com.task.manager.application.port.in.task;

import com.task.manager.domain.model.TaskDTO;

/**
 * The interface Update task use case.
 */
public interface UpdateTaskUseCase {

    /**
     * Update task.
     *
     * @param taskDTO the task dto
     */
    void updateTask(TaskDTO taskDTO);

}
