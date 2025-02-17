package com.sansam.user.security.filter;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sansam.user.query.dto.UserQueryDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.IOException;
import java.util.ArrayList;

public class CustomAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    /* 해당 요청이 올 때 이 필터가 동작하도록 설정한다. */
    public CustomAuthenticationFilter() {
        super(new AntPathRequestMatcher("/api/v1/user/login", "POST"));
    }

    /* 필터 동작 시 수행할 코드 작성하는 메소드 */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException {
        /* request body에 담긴 정보를 우리가 만든 LoginRequest 타입에 담아준다.
         * Controller의 @RequestBody 어노테이션을 통해 자동으로 convert 되었던 부분을 filter에서 직접 처리하는 과정 */
        UserQueryDTO.LoginRequestDTO loginRequest = new ObjectMapper().readValue(request.getInputStream(), UserQueryDTO.LoginRequestDTO.class);
        return getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getId(), loginRequest.getPw(), new ArrayList<>())
        );
    }
}
