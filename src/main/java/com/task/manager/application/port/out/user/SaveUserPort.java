package com.task.manager.application.port.out.user;

import com.task.manager.domain.model.UserDTO;

/**
 * The interface Save user port.
 */
public interface SaveUserPort {

    /**
     * Save user user dto.
     *
     * @param user the user
     * @return the user dto
     */
    UserDTO saveUser(UserDTO user);

}
