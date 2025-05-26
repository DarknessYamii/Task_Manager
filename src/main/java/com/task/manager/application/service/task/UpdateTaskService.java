package com.task.manager.application.service.task;

import com.task.manager.application.port.in.task.UpdateTaskUseCase;
import com.task.manager.application.port.out.task.UpdateTaskPort;
import com.task.manager.domain.model.TaskDTO;
import org.springframework.stereotype.Service;

/**
 * The type Update task service.
 */
@Service
public class UpdateTaskService implements UpdateTaskUseCase {

    private final UpdateTaskPort updateTaskPort;

    /**
     * Instantiates a new Update task service.
     *
     * @param updateTaskPort the update task port
     */
    public UpdateTaskService(UpdateTaskPort updateTaskPort) {
        this.updateTaskPort = updateTaskPort;
    }

    @Override
    public void updateTask(TaskDTO taskDTO) {

        updateTaskPort.updateTask(taskDTO);
    }
}
