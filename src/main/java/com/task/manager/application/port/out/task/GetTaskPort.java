package com.task.manager.application.port.out.task;

import com.task.manager.domain.model.TaskDTO;

import java.util.List;

/**
 * The interface Get task port.
 */
public interface GetTaskPort {

    /**
     * Gets task.
     *
     * @param taskId the task id
     * @return the task
     */
    TaskDTO getTask(long taskId);

    /**
     * Gets task by name.
     *
     * @param taskName the task name
     * @return the task by name
     */
    TaskDTO getTaskByName(String taskName);

    /**
     * Gets all tasks.
     *
     * @return the all tasks
     */
    List<TaskDTO> getAllTasks();

}
