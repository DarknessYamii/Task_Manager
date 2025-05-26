package com.task.manager.application.service.task;

import com.task.manager.application.port.in.task.CreateTaskUseCase;
import com.task.manager.application.port.out.task.SaveTaskPort;
import com.task.manager.domain.model.TaskDTO;
import org.springframework.stereotype.Service;

/**
 * The type Create task service.
 */
@Service
public class CreateTaskService implements CreateTaskUseCase {

    private final SaveTaskPort saveTaskPort;

    /**
     * Instantiates a new Create task service.
     *
     * @param saveTaskPort the save task port
     */
    public CreateTaskService(SaveTaskPort saveTaskPort) {
        this.saveTaskPort = saveTaskPort;
    }


    @Override
    public TaskDTO createTask(TaskDTO task) {
        return saveTaskPort.saveTask(task);
    }
}
