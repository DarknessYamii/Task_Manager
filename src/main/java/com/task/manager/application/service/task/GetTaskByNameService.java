package com.task.manager.application.service.task;

import com.task.manager.application.port.in.task.GetTaskByNameUseCase;
import com.task.manager.application.port.out.task.GetTaskPort;
import com.task.manager.domain.model.TaskDTO;
import org.springframework.stereotype.Service;

/**
 * The type Get task by name service.
 */
@Service
public class GetTaskByNameService implements GetTaskByNameUseCase {

    private final GetTaskPort getTaskPort;

    /**
     * Instantiates a new Get task by name service.
     *
     * @param getTaskPort the get task port
     */
    public GetTaskByNameService(GetTaskPort getTaskPort) {
        this.getTaskPort = getTaskPort;
    }


    @Override
    public TaskDTO getTaskByName(String taskName) {
        return getTaskPort.getTaskByName(taskName);
    }
}
