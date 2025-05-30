package com.task.manager.application.service.user;

import com.task.manager.application.port.in.user.DeleteUserUseCase;
import com.task.manager.application.port.out.task.DeleteTaskPort;
import com.task.manager.application.port.out.user.DeleteUserPort;
import org.springframework.stereotype.Service;

/**
 * The type Delete user service.
 */
@Service
public class DeleteUserService implements DeleteUserUseCase {

    private final DeleteUserPort deleteUserPort;

    /**
     * Instantiates a new Delete user service.
     *
     * @param deleteUserPort the delete task port
     */
    public DeleteUserService(DeleteUserPort deleteUserPort) {
        this.deleteUserPort = deleteUserPort;
    }


    @Override
    public void deleteUser(long userId) {
        deleteUserPort.deleteUser(userId);
    }
}
