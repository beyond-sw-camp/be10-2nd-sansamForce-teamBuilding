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

        User user = parseUserSpecification(token);

        if (user != null) {
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

    private User parseUserSpecification(String token) {
        // 토큰 유효성 검증 후 subject 파싱
        String subject = Optional.ofNullable(token)
                .filter(subjectStr -> subjectStr.length() >= 10)  // 길이 조건 추가
                .map(jwtUtil::validateTokenAndGetSubject)
                .orElse("anonymous:anonymous");

        String[] split = subject.split(":");
        if (split.length < 2) {
            throw new IllegalArgumentException("Invalid token format");
        }

        return new User(split[0], "", List.of(new SimpleGrantedAuthority(split[1])));
    }

    /*@Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = null;
        try {
            token = resolveToken((HttpServletRequest) request);
        } catch (SignatureException e) {
            throw new RuntimeException(e);
        }

        if (token != null && jwtUtil.validateToken(token)) {
            Authentication authentication = jwtUtil.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        chain.doFilter(request, response);
    }

    private String resolveToken(HttpServletRequest request) throws SignatureException {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.split(" ")[1];
        }

        return null;
    }*/

}

