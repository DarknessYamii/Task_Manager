package com.task.manager.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll()   // Consola H2 sin seguridad
                        .anyRequest().permitAll()                        // Permite todas las demás peticiones sin autenticación
                )
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/h2-console/**")      // Desactiva CSRF para consola H2
                        .disable()                                       // Desactiva CSRF para todas las rutas (opcional para pruebas)
                )
                .headers(headers -> headers
                        .frameOptions(frame -> frame.sameOrigin())      // Permite frames para consola H2
                );

        return http.build();
    }
}
