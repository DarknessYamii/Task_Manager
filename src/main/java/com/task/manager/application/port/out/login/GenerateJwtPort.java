package com.task.manager.application.port.out.login;

import org.springframework.security.core.userdetails.UserDetails;

public interface GenerateJwtPort {
    String generateToken(UserDetails user);
    boolean validateToken(String token);
    String extractUsername(String token);
}