package com.task.manager.application.port.in.task;

import com.task.manager.domain.model.TaskDTO;

/**
 * The interface Get task by name use case.
 */
public interface GetTaskByNameUseCase {

    /**
     * Gets task by name.
     *
     * @param taskName the task name
     * @return the task by name
     */
    TaskDTO getTaskByName(String taskName);

}
