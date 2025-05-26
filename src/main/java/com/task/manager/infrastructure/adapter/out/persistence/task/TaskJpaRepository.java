package com.task.manager.infrastructure.adapter.out.persistence.task;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * The interface Task jpa repository.
 */
public interface TaskJpaRepository extends JpaRepository<TaskEntity, Long> {

    /**
     * Find by task name optional.
     *
     * @param taskName the task name
     * @return the optional
     */
    @Query(value = "SELECT t FROM TaskEntity t WHERE t.taskName = :taskName ")
    Optional<TaskEntity> findByTaskName(@Param("taskName") String taskName);


    /**
     * Update task.
     *
     * @param id              the id
     * @param taskName        the task name
     * @param taskDescription the task description
     * @param taskStatus      the task status
     */
    @Modifying
    @Transactional
    @Query("UPDATE TaskEntity t SET t.taskName = :taskName, t.taskDescription = :taskDescription, t.taskStatus = :taskStatus WHERE t.taskId = :id")
    void updateTask(@Param("id") long id,
                    @Param("taskName") String taskName,
                    @Param("taskDescription") String taskDescription,
                    @Param("taskStatus") String taskStatus);
}
