package com.task.manager.infrastructure.adapter.out.persistence.user;

import com.task.manager.domain.model.UserDTO;
import com.task.manager.domain.model.UserRole;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * The type User mapper.
 */
@Component
public class UserMapper {

    /**
     * Save user mapper user entity.
     *
     * @param userDTO the user dto
     * @return the user entity
     */
    public UserEntity saveUserMapper(UserDTO userDTO) {
        return new UserEntity().builder().userName(userDTO.getUserName()).password(userDTO.getPassword()).
                email(userDTO.getEmail()).role(UserConstants.ROLE_USER).
                createdDate(String.valueOf(LocalDate.now())).phone(userDTO.getPhone()).status(UserConstants.ACTIVE).build();

    }


    /**
     * Entity to dto user dto.
     *
     * @param userEntity the user entity
     * @return the user dto
     */
    public UserDTO entityToDto(UserEntity userEntity) {
        return new UserDTO().builder().id(userEntity.getId()).userName(userEntity.getUserName()).
                password(userEntity.getPassword()).status(userEntity.getStatus()).status(userEntity.getStatus()).
                email(userEntity.getEmail()).phone(userEntity.getPhone()).createdDate(userEntity.getCreatedDate()).role(userEntity.getRole()).build();
    }
}
