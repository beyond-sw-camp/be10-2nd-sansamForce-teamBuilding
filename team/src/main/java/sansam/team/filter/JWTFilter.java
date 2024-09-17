package sansam.team.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHeaders;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.filter.OncePerRequestFilter;
import sansam.team.common.jwt.JWTUtil;
import sansam.team.user.command.entity.User;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class JWTFilter extends OncePerRequestFilter {
    private final JWTUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = parseBearerToken(request);

        // 토큰이 없으면 다음 필터로 진행
        if (token == null) {
            filterChain.doFilter(request, response);
            return;
        }

        // 유효한 토큰일 경우 subject와 auth를 파싱
        String subject = jwtUtil.validateTokenAndGetSubject(token);
        String auth = jwtUtil.getAuthFromToken(token);

        // 사용자 정보와 권한이 올바르게 파싱되면 인증 객체 생성
        if (subject != null && auth != null) {
            User user = new User(subject, "", List.of(new SimpleGrantedAuthority(auth)));
            AbstractAuthenticationToken authenticated =
                    UsernamePasswordAuthenticationToken.authenticated(user, token, user.getAuthorities());
            authenticated.setDetails(new WebAuthenticationDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticated);
        }

        filterChain.doFilter(request, response);
    }

    private String parseBearerToken(HttpServletRequest request) {
        return Optional.ofNullable(request.getHeader(HttpHeaders.AUTHORIZATION))
                .filter(token -> token.startsWith("Bearer "))
                .map(token -> token.substring(7))
                .orElse(null);
    }
}
