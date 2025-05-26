package com.task.manager.infrastructure.adapter.out.persistence.task;

import com.task.manager.application.port.out.task.DeleteTaskPort;
import com.task.manager.application.port.out.task.GetTaskPort;
import com.task.manager.application.port.out.task.SaveTaskPort;
import com.task.manager.application.port.out.task.UpdateTaskPort;
import com.task.manager.domain.model.TaskDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The type Task persistence adapter.
 */
@Repository
public class TaskPersistenceAdapter implements SaveTaskPort, UpdateTaskPort, DeleteTaskPort, GetTaskPort {

    private final TaskJpaRepository taskJpaRepository;
    private final TaskMapper taskMapper;

    /**
     * Instantiates a new Task persistence adapter.
     *
     * @param taskJpaRepository the task jpa repository
     * @param taskMapper        the task mapper
     */
    public TaskPersistenceAdapter(TaskJpaRepository taskJpaRepository, TaskMapper taskMapper) {
        this.taskJpaRepository = taskJpaRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public void deleteTask(long taskId) {
        taskJpaRepository.deleteById(taskId);
    }

    @Override
    public TaskDTO saveTask(TaskDTO task) {
        TaskDTO taskDTO = taskMapper.entityToDto(taskJpaRepository.save(taskMapper.saveTaskMapper(task)));
        return taskDTO;
    }

    @Override
    public void updateTask(TaskDTO task) {
        TaskEntity taskEntity = taskMapper.saveTaskMapper(task);
        taskJpaRepository.updateTask(taskEntity.getTaskId(), taskEntity.getTaskName(), taskEntity.getTaskDescription(), taskEntity.getTaskStatus());

    }

    @Override
    public TaskDTO getTask(long taskId) {
        return taskJpaRepository.findById(taskId).map(taskMapper::entityToDto).orElse(null);
    }

    @Override
    public TaskDTO getTaskByName(String taskName) {
        return taskJpaRepository.findByTaskName(taskName).map(taskMapper::entityToDto).orElse(null);
    }

    @Override
    public List<TaskDTO> getAllTasks() {
        return taskJpaRepository.findAll().stream().map(taskMapper::entityToDto).toList();
    }
}
