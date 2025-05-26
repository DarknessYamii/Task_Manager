package com.task.manager.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type User dto.
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private long id;

    private String userName;

    private String password;

    private String role;

    private String email;

    private String phone;

    private String status;

    private String createdDate;

}
