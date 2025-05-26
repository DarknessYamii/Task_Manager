package com.task.manager.infrastructure.adapter.in.web;

import com.task.manager.application.port.in.task.CreateTaskUseCase;
import com.task.manager.application.port.in.task.DeleteTaskUseCase;
import com.task.manager.application.port.in.task.GetAllTaskUseCase;
import com.task.manager.application.port.in.task.GetTaskByIdUseCase;
import com.task.manager.application.port.in.task.GetTaskByNameUseCase;
import com.task.manager.application.port.in.task.UpdateTaskUseCase;
import com.task.manager.domain.model.TaskDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Task controller.
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final CreateTaskUseCase createTaskUseCase;
    private final GetTaskByIdUseCase getTaskByIdUseCase;
    private final GetTaskByNameUseCase getTaskByNameUseCase;
    private final UpdateTaskUseCase updateTaskUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;
    private final GetAllTaskUseCase getAllTaskUseCase;

    /**
     * Instantiates a new Task controller.
     *
     * @param createTaskUseCase    the create task use case
     * @param getTaskByIdUseCase   the get task by id use case
     * @param getTaskByNameUseCase the get task by name use case
     * @param updateTaskUseCase    the update task use case
     * @param deleteTaskUseCase    the delete task use case
     * @param getAllTaskUseCase    the get all task use case
     */
    public TaskController(CreateTaskUseCase createTaskUseCase, GetTaskByIdUseCase getTaskByIdUseCase, GetTaskByNameUseCase getTaskByNameUseCase, UpdateTaskUseCase updateTaskUseCase, DeleteTaskUseCase deleteTaskUseCase, GetAllTaskUseCase getAllTaskUseCase) {
        this.createTaskUseCase = createTaskUseCase;
        this.getTaskByIdUseCase = getTaskByIdUseCase;
        this.getTaskByNameUseCase = getTaskByNameUseCase;
        this.updateTaskUseCase = updateTaskUseCase;
        this.deleteTaskUseCase = deleteTaskUseCase;
        this.getAllTaskUseCase = getAllTaskUseCase;
    }


    /**
     * Create task response entity.
     *
     * @param taskDTO the task dto
     * @return the response entity
     */
    @PostMapping(value = "/create")
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDTO) {
        try {
            TaskDTO task = createTaskUseCase.createTask(taskDTO);
            return ResponseEntity.ok(task);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }

    /**
     * Gets task.
     *
     * @param taskId the task id
     * @return the task
     */
    @GetMapping(value = "/get/id/{taskId}")
    public ResponseEntity<TaskDTO> getTask(@PathVariable long taskId) {
        try {
            TaskDTO task = getTaskByIdUseCase.getTask(taskId);
            return ResponseEntity.ok(task);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Gets task by name.
     *
     * @param taskName the task name
     * @return the task by name
     */
    @GetMapping(value = "/get/name/{taskName}")
    public ResponseEntity<TaskDTO> getTaskByName(@PathVariable String taskName) {
        try {
            TaskDTO task = getTaskByNameUseCase.getTaskByName(taskName);
            return ResponseEntity.ok(task);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Update task response entity.
     *
     * @param taskDTO the task dto
     * @return the response entity
     */
    @PatchMapping(value = "/update")
    public ResponseEntity<?> updateTask(@RequestBody TaskDTO taskDTO) {
        try {
            updateTaskUseCase.updateTask(taskDTO);
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Delete task response entity.
     *
     * @param taskId the task id
     * @return the response entity
     */
    @DeleteMapping(value = "/delete/{taskId}")
    public ResponseEntity<?> deleteTask(@PathVariable long taskId) {
        try {
            deleteTaskUseCase.deleteTask(taskId);
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Gets all tasks.
     *
     * @return the all tasks
     */
    @GetMapping(value = "/get/all")
    public ResponseEntity<List<TaskDTO>> getAllTasks() {
        try {
            List<TaskDTO> task = getAllTaskUseCase.getAllTasks();
            return ResponseEntity.ok(task);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
