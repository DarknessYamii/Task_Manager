package com.task.manager.application.port.out.task;

/**
 * The interface Delete task port.
 */
public interface DeleteTaskPort {

    /**
     * Delete task.
     *
     * @param taskId the task id
     */
    void deleteTask(long taskId);


}
