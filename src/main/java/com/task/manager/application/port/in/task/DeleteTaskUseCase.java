package com.task.manager.application.port.in.task;

/**
 * The interface Delete task use case.
 */
public interface DeleteTaskUseCase {

    /**
     * Delete task.
     *
     * @param taskId the task id
     */
    void deleteTask(long taskId);
}
