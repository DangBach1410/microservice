package vti.dtn.authservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    private static final String[] WHITE_LIST_URL = {
        "/api/v1/auth/users/register", "/api/v1/auth/login", "/api/v1/auth/refresh-token", "/api/v1/auth/verify-token"
    };

    @SuppressWarnings("removal")
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeHttpRequests()
            .requestMatchers(WHITE_LIST_URL).permitAll()
            .anyRequest().authenticated()
            .and()
            .httpBasic();

        return http.build();
    }
}
