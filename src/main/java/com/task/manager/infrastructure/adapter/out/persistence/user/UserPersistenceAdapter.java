package com.task.manager.infrastructure.adapter.out.persistence.user;

import com.task.manager.application.port.out.user.DeleteUserPort;
import com.task.manager.application.port.out.user.GetUserPort;
import com.task.manager.application.port.out.user.SaveUserPort;
import com.task.manager.domain.model.UserDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The type User persistence adapter.
 */
@Repository
public class UserPersistenceAdapter implements SaveUserPort, DeleteUserPort, GetUserPort {

    private final UserJpaRepository userJpaRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    /**
     * Instantiates a new User persistence adapter.
     *
     * @param userJpaRepository the user jpa repository
     * @param userMapper        the user mapper
     */
    public UserPersistenceAdapter(UserJpaRepository userJpaRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userJpaRepository = userJpaRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void deleteUser(long userId) {
        userJpaRepository.deleteById(userId);
    }

    /**
     *
     */
    @Override
    public void deleteAllUsers() {
        userJpaRepository.deleteAll();

    }

    @Override
    public UserDTO saveUser(UserDTO user) {
        UserEntity userEntity = userMapper.saveUserMapper(user);
        userEntity.setRealPass(user.getPassword());
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
        return userMapper.entityToDto(userJpaRepository.save(userEntity));

    }

    @Override
    public UserDTO getUser(long userId) {
        return userJpaRepository.findById(userId).map(userMapper::entityToDto).orElse(null);
    }

    @Override
    public UserDTO getUserByUserName(String userName) {
        return userJpaRepository.findByUserName(userName).map(userMapper::entityToDto).orElse(null);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return List.of(userJpaRepository.findAll().stream().map(userMapper::entityToDto).toArray(UserDTO[]::new));
    }
}
