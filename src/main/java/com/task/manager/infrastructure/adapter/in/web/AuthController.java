package com.task.manager.infrastructure.adapter.in.web;

import com.task.manager.application.port.in.login.LoginUseCase;
import com.task.manager.domain.model.JwtResponse;
import com.task.manager.domain.model.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final LoginUseCase loginUseCase;

    public AuthController(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest request) {
        JwtResponse tokenResponse = loginUseCase.login(request.getUsername(), request.getPassword());
        String token = tokenResponse.getToken();
        return ResponseEntity.ok(Map.of("token", token));
    }
}