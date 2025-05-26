package com.task.manager.infrastructure.adapter.out.persistence.task;

import com.task.manager.domain.model.TaskDTO;
import org.springframework.stereotype.Component;

/**
 * The type Task mapper.
 */
@Component
public class TaskMapper {

    /**
     * Save task mapper task entity.
     *
     * @param taskDTO the task dto
     * @return the task entity
     */
    public TaskEntity saveTaskMapper(TaskDTO taskDTO) {

        return new TaskEntity().builder().taskName(taskDTO.getTaskName())
                .taskDescription(taskDTO.getTaskDescription())
                .taskStatus(taskDTO.getTaskStatus()).build();

    }

    /**
     * Entity to dto task dto.
     *
     * @param taskEntity the task entity
     * @return the task dto
     */
    public TaskDTO entityToDto(TaskEntity taskEntity) {

        return new TaskDTO().builder().id(taskEntity.getTaskId()).taskName(taskEntity.getTaskName())
                .taskDescription(taskEntity.getTaskDescription())
                .taskStatus(taskEntity.getTaskStatus()).build();

    }

}
