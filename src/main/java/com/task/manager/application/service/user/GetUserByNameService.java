package com.task.manager.application.service.user;

import com.task.manager.application.port.in.user.GetUserByNameUseCase;
import com.task.manager.application.port.out.user.GetUserPort;
import com.task.manager.domain.model.UserDTO;
import org.springframework.stereotype.Service;

/**
 * The type Get user by name service.
 */
@Service
public class GetUserByNameService implements GetUserByNameUseCase {

    private final GetUserPort getUserPort;

    /**
     * Instantiates a new Get user by name service.
     *
     * @param getUserPort the get user port
     */
    public GetUserByNameService(GetUserPort getUserPort) {
        this.getUserPort = getUserPort;
    }

    @Override
    public UserDTO getUserByUserName(String userName) {
        return getUserPort.getUserByUserName(userName);
    }
}
