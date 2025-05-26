package com.task.manager.application.port.in.user;

/**
 * The interface Delete user use case.
 */
public interface DeleteUserUseCase {

    /**
     * Delete user.
     *
     * @param userId the user id
     */
    void deleteUser(long userId);


}
