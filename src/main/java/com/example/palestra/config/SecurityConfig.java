package com.example.palestra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                                .requestMatchers("/api/utenti/**").permitAll() // Permetti accesso pubblico agli utenti
                                .requestMatchers("/api/corsi").permitAll()
                                .requestMatchers("/api/iscrizioni/**").permitAll()
                                .anyRequest().authenticated() // Tutti gli altri endpoint richiedono autenticazione
                )
                .httpBasic(); // Usa Basic Auth per altri endpoint
        return http.build();
    }
}
