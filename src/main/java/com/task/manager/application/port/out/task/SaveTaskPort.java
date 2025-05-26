package com.task.manager.application.port.out.task;

import com.task.manager.domain.model.TaskDTO;

/**
 * The interface Save task port.
 */
public interface SaveTaskPort {

    /**
     * Save task task dto.
     *
     * @param task the task
     * @return the task dto
     */
    TaskDTO saveTask(TaskDTO task);

}
