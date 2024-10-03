package sansam.team.security.util;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import sansam.team.exception.CustomException;
import sansam.team.exception.ErrorCodeType;
import sansam.team.user.command.domain.aggregate.entity.User;

@Component
public class SecurityUtil {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static User getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof User) {
            return (User) authentication.getPrincipal();
        }
        throw new IllegalArgumentException("User not authenticated");
    }

    public static String getUserAuth() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(ObjectUtils.isNotEmpty(authentication)) {
            String userInfo = authentication.getName();
            if(userInfo.contains(",")) {
                String[] user = userInfo.split(",");
                return user[2];
            }
        }
        throw new CustomException(ErrorCodeType.MEMBER_NOT_FOUND);
    }

}
