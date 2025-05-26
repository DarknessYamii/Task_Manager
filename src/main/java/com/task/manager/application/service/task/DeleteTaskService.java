package com.task.manager.application.service.task;

import com.task.manager.application.port.in.task.DeleteTaskUseCase;
import com.task.manager.application.port.out.task.DeleteTaskPort;
import org.springframework.stereotype.Service;

/**
 * The type Delete task service.
 */
@Service
public class DeleteTaskService implements DeleteTaskUseCase {

    private final DeleteTaskPort deleteTaskPort;

    /**
     * Instantiates a new Delete task service.
     *
     * @param deleteTaskPort the delete task port
     */
    public DeleteTaskService(DeleteTaskPort deleteTaskPort) {
        this.deleteTaskPort = deleteTaskPort;
    }

    @Override
    public void deleteTask(long taskId) {
        deleteTaskPort.deleteTask(taskId);
    }
}
