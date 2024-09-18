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

        try {
            // JWT 토큰에서 userSeq와 auth 권한 파싱
            Long userSeq = jwtUtil.getUserSeqFromToken(token);  // userSeq 추출
            String auth = jwtUtil.getAuthFromToken(token);      // 권한 추출

            // userSeq와 auth가 null이 아닐 때만 인증 처리
            if (userSeq != null && auth != null) {
                // JWT의 auth에서 권한 추출
                List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(auth));

                // User 객체 생성 및 userSeq 설정
                User user = new User();
                user.setUserSeq(userSeq);

                // 로그로 권한 상태 확인
                log.info("JWT UserSeq: " + userSeq);
                log.info("JWT Auth: " + auth);
                log.info("User Authorities after setting: " + authorities);

                // 인증 객체 생성
                AbstractAuthenticationToken authenticated =
                        new UsernamePasswordAuthenticationToken(user, null, authorities);
                authenticated.setDetails(new WebAuthenticationDetails(request));

                // SecurityContext에 인증 객체 설정
                SecurityContextHolder.getContext().setAuthentication(authenticated);
            }
        } catch (Exception e) {
            // JWT 인증 실패 시 로그 출력 및 403 응답
            log.error("JWT Authentication failed", e);
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

        // 필터 체인 계속 진행
        filterChain.doFilter(request, response);
    }

    // Bearer 토큰을 헤더에서 파싱하는 메소드
    private String parseBearerToken(HttpServletRequest request) {
        return Optional.ofNullable(request.getHeader(HttpHeaders.AUTHORIZATION))
                .filter(token -> token.startsWith("Bearer "))
                .map(token -> token.substring(7))
                .orElse(null);
    }
}
