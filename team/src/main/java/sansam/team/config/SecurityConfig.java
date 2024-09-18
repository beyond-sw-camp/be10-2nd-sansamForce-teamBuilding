package sansam.team.config;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import sansam.team.common.jwt.JWTUtil;
import sansam.team.filter.JWTFilter;
import sansam.team.filter.LoginFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JWTUtil jwtUtil;
    private final AuthenticationConfiguration authenticationConfiguration;
    private final ModelMapper modelMapper;  // ModelMapper 주입

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizeRequest ->
                        authorizeRequest
                                .requestMatchers(
                                        "/",
                                        "/swagger-ui/**",
                                        "/v3/api-docs/**",
                                        "/api/v1/user/login",
                                        "/api/v1/user/join"
                                ).permitAll()
                                .requestMatchers("/api/v1/admin/**")
                                .hasAnyAuthority("MANAGER", "SUB_MANAGER")
                                .requestMatchers(
                                        "/api/v1/**"
                                ).hasAnyAuthority("MEMBER", "MENTOR", "MANAGER", "SUB_MANAGER")
                                .anyRequest().authenticated()
                )
                // LoginFilter는 UsernamePasswordAuthenticationFilter 앞에 위치시킵니다.
                .addFilterAt(new LoginFilter(authenticationManager(authenticationConfiguration), jwtUtil, modelMapper), UsernamePasswordAuthenticationFilter.class)
                // JWTFilter는 로그인 이후 JWT 검증을 담당하므로 UsernamePasswordAuthenticationFilter 뒤에 위치시킵니다.
                .addFilterAfter(new JWTFilter(jwtUtil), UsernamePasswordAuthenticationFilter.class)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers( "/error", "/error/*", "/img/**", "/favicon.ico");
    }
}

