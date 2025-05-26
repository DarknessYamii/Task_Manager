package com.task.manager.application.port.in.user;

import com.task.manager.domain.model.UserDTO;

/**
 * The interface Create user use case.
 */
public interface CreateUserUseCase {

    /**
     * Create user user dto.
     *
     * @param userDTO the user dto
     * @return the user dto
     */
    UserDTO createUser(UserDTO userDTO);

}
