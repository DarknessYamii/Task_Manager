package com.task.manager.application.port.in.user;

import com.task.manager.domain.model.UserDTO;

/**
 * The interface Get user by id use case.
 */
public interface GetUserByIdUseCase {

    /**
     * Gets user.
     *
     * @param userId the user id
     * @return the user
     */
    UserDTO getUser(long userId);
}
