package com.task.manager.application.service.user;

import com.task.manager.application.port.in.user.DeleteAllUserUseCase;
import com.task.manager.application.port.out.task.DeleteTaskPort;
import com.task.manager.application.port.out.user.DeleteUserPort;
import org.springframework.stereotype.Service;

@Service
public class DeleteAllUserService implements DeleteAllUserUseCase {

    private final DeleteUserPort deleteUserPort;

    public DeleteAllUserService(DeleteUserPort deleteUserPort) {
        this.deleteUserPort = deleteUserPort;
    }


    /**
     *
     */
    @Override
    public void deleteAllUsers() {
        deleteUserPort.deleteAllUsers();
    }
}
