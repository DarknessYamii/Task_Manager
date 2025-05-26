package com.task.manager.application.service.task;

import com.task.manager.application.port.in.task.GetAllTaskUseCase;
import com.task.manager.application.port.out.task.GetTaskPort;
import com.task.manager.domain.model.TaskDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Get all task service.
 */
@Service
public class GetAllTaskService implements GetAllTaskUseCase {

    private final GetTaskPort getTaskPort;

    /**
     * Instantiates a new Get all task service.
     *
     * @param getTaskPort the get task port
     */
    public GetAllTaskService(GetTaskPort getTaskPort) {
        this.getTaskPort = getTaskPort;
    }


    @Override
    public List<TaskDTO> getAllTasks() {
        return getTaskPort.getAllTasks();
    }
}
