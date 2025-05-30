package com.task.manager.domain.model;

import java.util.Set;

public enum UserRole {
    ADMIN(Set.of(UserPermission.READ_USER, UserPermission.CREATE_USER, UserPermission.DELETE_USER, UserPermission.UPDATE_USER, UserPermission.CREATE_TASK, UserPermission.DELETE_TASK, UserPermission.UPDATE_TASK, UserPermission.READ_TASK)),
    USER(Set.of(UserPermission.READ_USER, UserPermission.CREATE_TASK, UserPermission.DELETE_TASK, UserPermission.UPDATE_TASK, UserPermission.READ_TASK));

    private final Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }
}