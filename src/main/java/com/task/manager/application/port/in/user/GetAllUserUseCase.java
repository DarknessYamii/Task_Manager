package com.task.manager.application.port.in.user;

import com.task.manager.domain.model.UserDTO;

import java.util.List;

/**
 * The interface Get all user use case.
 */
public interface GetAllUserUseCase {

    /**
     * Gets all user.
     *
     * @return the all user
     */
    List<UserDTO> getAllUser();


}
