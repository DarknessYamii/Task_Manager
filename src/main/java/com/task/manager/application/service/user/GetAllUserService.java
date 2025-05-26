package com.task.manager.application.service.user;

import com.task.manager.application.port.in.user.GetAllUserUseCase;
import com.task.manager.application.port.out.user.GetUserPort;
import com.task.manager.domain.model.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Get all user service.
 */
@Service
public class GetAllUserService implements GetAllUserUseCase {

    private final GetUserPort getUserPort;

    /**
     * Instantiates a new Get all user service.
     *
     * @param getUserPort the get user port
     */
    public GetAllUserService(GetUserPort getUserPort) {
        this.getUserPort = getUserPort;
    }

    @Override
    public List<UserDTO> getAllUser() {
        return getUserPort.getAllUsers();
    }


}
