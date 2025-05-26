package com.task.manager.application.service.user;

import com.task.manager.application.port.in.user.DeleteUserUseCase;
import com.task.manager.application.port.out.task.DeleteTaskPort;
import org.springframework.stereotype.Service;

/**
 * The type Delete user service.
 */
@Service
public class DeleteUserService implements DeleteUserUseCase {

    private final DeleteTaskPort deleteTaskPort;

    /**
     * Instantiates a new Delete user service.
     *
     * @param deleteTaskPort the delete task port
     */
    public DeleteUserService(DeleteTaskPort deleteTaskPort) {
        this.deleteTaskPort = deleteTaskPort;
    }


    @Override
    public void deleteUser(long userId) {
        deleteTaskPort.deleteTask(userId);
    }
}
