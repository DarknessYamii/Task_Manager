package com.task.manager.infrastructure.adapter.in.web;


import com.task.manager.application.port.in.user.CreateUserUseCase;
import com.task.manager.application.port.in.user.DeleteAllUserUseCase;
import com.task.manager.application.port.in.user.DeleteUserUseCase;
import com.task.manager.application.port.in.user.GetAllUserUseCase;
import com.task.manager.application.port.in.user.GetUserByIdUseCase;
import com.task.manager.application.port.in.user.GetUserByNameUseCase;
import com.task.manager.domain.model.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type User controller.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private final DeleteUserUseCase deleteUserUseCase;
    private final CreateUserUseCase createUserUseCase;
    private final GetUserByIdUseCase getUserByIdUseCase;
    private final GetAllUserUseCase getAllUserUseCase;
    private final GetUserByNameUseCase getUserByNameUseCase;
    private final DeleteAllUserUseCase deleteAllUserUseCase;

    /**
     * Instantiates a new User controller.
     *
     * @param deleteUserUseCase    the delete user use case
     * @param createUserUseCase    the create user use case
     * @param getUserByIdUseCase   the get user by id use case
     * @param getAllUserUseCase    the get all user use case
     * @param getUserByNameUseCase the get user by name use case
     */
    public UserController(DeleteUserUseCase deleteUserUseCase, CreateUserUseCase createUserUseCase, GetUserByIdUseCase getUserByIdUseCase, GetAllUserUseCase getAllUserUseCase, GetUserByNameUseCase getUserByNameUseCase, DeleteAllUserUseCase deleteAllUserUseCase) {
        this.deleteUserUseCase = deleteUserUseCase;
        this.createUserUseCase = createUserUseCase;
        this.getUserByIdUseCase = getUserByIdUseCase;
        this.getAllUserUseCase = getAllUserUseCase;
        this.getUserByNameUseCase = getUserByNameUseCase;
        this.deleteAllUserUseCase = deleteAllUserUseCase;
    }

    /**
     * Delete user response entity.
     *
     * @param userId the user id
     * @return the response entity
     */
    @DeleteMapping(value = "/delete/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable long userId) {
        try {
            deleteUserUseCase.deleteUser(userId);
            return ResponseEntity.ok(userId);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }

    /**
     * Create user response entity.
     *
     * @param userDTO the user dto
     * @return the response entity
     */
    @PostMapping(value = "/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        try {
            UserDTO user = createUserUseCase.createUser(userDTO);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Gets user.
     *
     * @param userId the user id
     * @return the user
     */
    @GetMapping(value = "/get/id/{userId}")
    public ResponseEntity<UserDTO> getUser(@PathVariable long userId) {
        try {
            UserDTO user = getUserByIdUseCase.getUser(userId);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Gets user by name.
     *
     * @param userName the user name
     * @return the user by name
     */
    @GetMapping(value = "/get/name/{userName}")
    public ResponseEntity<UserDTO> getUserByName(@PathVariable String userName) {
        try {
            UserDTO user = getUserByNameUseCase.getUserByUserName(userName);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Gets all users.
     *
     * @return the all users
     */
    @GetMapping(value = "/get/all")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        try {
            List<UserDTO> user = getAllUserUseCase.getAllUser();
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping(value = "/delete/all")
    public ResponseEntity<?> deleteAllUsers() {
        try {
            deleteAllUserUseCase.deleteAllUsers();
            return ResponseEntity.ok(HttpStatus.OK);
        }catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}