package com.hai925i.campus.config;

import com.hai925i.campus.domain.UserRepository;
import com.hai925i.campus.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.authentication.DefaultAuthenticationEventPublisher;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationSuccessHandler successHandler) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        // les pages accessibles à tous (CSS, JS, Login, ET la page d'accueil "/")
                        // il faut autoriser explicitement /login ici aussi pour éviter une boucle de redirection
                        .requestMatchers("/", "/login", "/css/**", "/js/**", "/webjars/**").permitAll()

                        /* ---------- configuration des droits en fonction des roles - */
                        .requestMatchers("/salles/delete/**").hasRole("ADMIN")
                        .requestMatchers("/salles/add", "/salles/save", "/salles/edit/**", "/salles/update").hasAnyRole("ADMIN", "ENSEIGNANT")

                        // Tout le reste nécessite d'être connecté (ex: /dashboard, /salles)
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                        .successHandler(successHandler)
                )
                .logout((logout) -> logout.permitAll());

        return http.build();
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler(UserRepository userRepository) {
        return new SimpleUrlAuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                                Authentication authentication) throws IOException, ServletException {
                
                String username = authentication.getName();
                User user = userRepository.findByUsername(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
                
                user.setLastLoginDate(LocalDateTime.now());
                userRepository.save(user);
                
                setDefaultTargetUrl("/dashboard");
                super.onAuthenticationSuccess(request, response, authentication);
            }
        };
    }
}