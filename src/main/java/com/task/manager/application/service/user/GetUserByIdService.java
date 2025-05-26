package com.task.manager.application.service.user;

import com.task.manager.application.port.in.user.GetUserByIdUseCase;
import com.task.manager.application.port.out.user.GetUserPort;
import com.task.manager.domain.model.UserDTO;
import org.springframework.stereotype.Service;

/**
 * The type Get user by id service.
 */
@Service
public class GetUserByIdService implements GetUserByIdUseCase {

    private final GetUserPort getUserPort;

    /**
     * Instantiates a new Get user by id service.
     *
     * @param getUserPort the get user port
     */
    public GetUserByIdService(GetUserPort getUserPort) {
        this.getUserPort = getUserPort;
    }

    @Override
    public UserDTO getUser(long userId) {
        return getUserPort.getUser(userId);
    }
}
