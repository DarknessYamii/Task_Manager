package com.task.manager.application.port.out.user;

/**
 * The interface Delete user port.
 */
public interface DeleteUserPort {

    /**
     * Delete user.
     *
     * @param userId the user id
     */
    void deleteUser(long userId);

}
