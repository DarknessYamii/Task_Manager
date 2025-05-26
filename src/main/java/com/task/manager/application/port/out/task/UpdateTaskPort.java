package com.task.manager.application.port.out.task;

import com.task.manager.domain.model.TaskDTO;

/**
 * The interface Update task port.
 */
public interface UpdateTaskPort {

    /**
     * Update task.
     *
     * @param task the task
     */
    void updateTask(TaskDTO task);

}
