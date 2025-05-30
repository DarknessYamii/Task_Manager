package com.task.manager.application.service.login;

import com.task.manager.application.port.in.login.LoginUseCase;
import com.task.manager.application.port.out.login.GenerateJwtPort;
import com.task.manager.domain.model.JwtResponse;
import com.task.manager.infrastructure.adapter.out.persistence.login.CustomUserDetailsService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements LoginUseCase {

    private final AuthenticationManager authenticationManager;
    private final GenerateJwtPort generateJwtPort;
    private final CustomUserDetailsService userDetailsService;

    public AuthService(AuthenticationManager authenticationManager,
                       GenerateJwtPort generateJwtPort,
                       CustomUserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.generateJwtPort = generateJwtPort;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public JwtResponse login(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        var userDetails = userDetailsService.loadUserByUsername(username);
        var token = generateJwtPort.generateToken(userDetails);

        return new JwtResponse(token, username, userDetails.getAuthorities().toString());
    }
}