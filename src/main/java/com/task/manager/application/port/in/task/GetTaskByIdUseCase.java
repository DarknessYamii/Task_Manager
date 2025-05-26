package com.task.manager.application.port.in.task;

import com.task.manager.domain.model.TaskDTO;

/**
 * The interface Get task by id use case.
 */
public interface GetTaskByIdUseCase {

    /**
     * Gets task.
     *
     * @param taskId the task id
     * @return the task
     */
    TaskDTO getTask(long taskId);

}
