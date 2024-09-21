package sansam.team.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import sansam.team.common.jwt.JWTUtil;
import sansam.team.user.command.dto.JwtToken;
import sansam.team.user.command.dto.UserDTO;
import sansam.team.user.command.entity.User;

import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@RequiredArgsConstructor
public class LoginFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;
    private final ModelMapper modelMapper;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String userName = obtainUsername(request);
        String password = obtainPassword(request);

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userName, password, null);
        Authentication authentication = authenticationManager.authenticate(authToken);

        log.info("request userid = {}, password = {}", userName, password);

        return authentication;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException {
        log.info("=======로그인 성공=======");

        // User 객체 가져오기
        User user = (User) authentication.getPrincipal();

        // JWT 토큰 생성 (User 객체를 매개변수로 전달)
        JwtToken jwtToken = jwtUtil.createToken(user);

        // UserDTO로 변환 후 JWT 토큰 세팅
        UserDTO loginUserInfo = modelMapper.map(user, UserDTO.class);
        loginUserInfo.setJwtToken(jwtToken);

        log.info("토큰 발급 완료 - accessToken : {}, refreshToken : {}", jwtToken.getAccessToken(), jwtToken.getRefreshToken());

        // 응답으로 JWT 토큰 전송
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpStatus.OK.value());

        PrintWriter out = response.getWriter();
        out.write("{\"accessToken\":\"" + jwtToken.getAccessToken() + "\", \"refreshToken\":\"" + jwtToken.getRefreshToken() + "\", \"userId\":\"" + user.getUserId() + "\"}");
        out.flush();
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) {
        log.error("로그인 실패");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
    }
}

