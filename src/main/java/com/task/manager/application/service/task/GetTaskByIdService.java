package com.task.manager.application.service.task;

import com.task.manager.application.port.in.task.GetTaskByIdUseCase;
import com.task.manager.application.port.out.task.GetTaskPort;
import com.task.manager.domain.model.TaskDTO;
import org.springframework.stereotype.Service;

/**
 * The type Get task by id service.
 */
@Service
public class GetTaskByIdService implements GetTaskByIdUseCase {

    private final GetTaskPort getTaskPort;

    /**
     * Instantiates a new Get task by id service.
     *
     * @param getTaskPort the get task port
     */
    public GetTaskByIdService(GetTaskPort getTaskPort) {
        this.getTaskPort = getTaskPort;
    }


    @Override
    public TaskDTO getTask(long taskId) {
        return getTaskPort.getTask(taskId);
    }
}
