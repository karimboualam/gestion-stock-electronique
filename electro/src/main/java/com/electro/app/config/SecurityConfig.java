package com.electro.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class SecurityConfig  implements WebMvcConfigurer {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Nouvelle syntaxe pour désactiver CSRF
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()  // Permet l'accès sans authentification pour toutes les requêtes
                );  // Désactive l'authentification basique HTTP
        return http.build();
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200")  // Autoriser l'origine de votre frontend Angular
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Autoriser les méthodes HTTP
                .allowedHeaders("*")  // Autoriser tous les headers
                .allowCredentials(true);  // Permet les cookies si nécessaire
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
