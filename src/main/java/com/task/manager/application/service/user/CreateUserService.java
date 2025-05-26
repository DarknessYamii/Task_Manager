package com.task.manager.application.service.user;

import com.task.manager.application.port.in.user.CreateUserUseCase;
import com.task.manager.application.port.out.user.SaveUserPort;
import com.task.manager.domain.model.UserDTO;
import org.springframework.stereotype.Service;

/**
 * The type Create user service.
 */
@Service
public class CreateUserService implements CreateUserUseCase {

    private final SaveUserPort saveUserPort;

    /**
     * Instantiates a new Create user service.
     *
     * @param saveUserPort the save user port
     */
    public CreateUserService(SaveUserPort saveUserPort) {
        this.saveUserPort = saveUserPort;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        return saveUserPort.saveUser(userDTO);
    }
}
