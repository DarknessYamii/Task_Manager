package com.task.manager.application.port.out.user;

import com.task.manager.domain.model.UserDTO;

import java.util.List;

/**
 * The interface Get user port.
 */
public interface GetUserPort {

    /**
     * Gets user.
     *
     * @param userId the user id
     * @return the user
     */
    UserDTO getUser(long userId);

    /**
     * Gets user by user name.
     *
     * @param userName the user name
     * @return the user by user name
     */
    UserDTO getUserByUserName(String userName);

    /**
     * Gets all users.
     *
     * @return the all users
     */
    List<UserDTO> getAllUsers();

}
