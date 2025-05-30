package com.task.manager.application.port.in.login;

import com.task.manager.domain.model.JwtResponse;

public interface LoginUseCase {
    JwtResponse login(String username, String password);
}

