package com.task.manager.application.port.in.user;

import com.task.manager.domain.model.UserDTO;

/**
 * The interface Get user by name use case.
 */
public interface GetUserByNameUseCase {

    /**
     * Gets user by user name.
     *
     * @param userName the user name
     * @return the user by user name
     */
    UserDTO getUserByUserName(String userName);

}
