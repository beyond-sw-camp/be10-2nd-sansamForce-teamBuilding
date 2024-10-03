package sansam.team.security.util;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import sansam.team.user.command.domain.aggregate.entity.User;
import sansam.team.user.query.dto.CustomUserDTO;

@Component
public class SecurityUtil {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static CustomUserDTO getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof CustomUserDTO) {
            return (CustomUserDTO) authentication.getPrincipal();
        }
        throw new IllegalArgumentException("User not authenticated");
    }

}