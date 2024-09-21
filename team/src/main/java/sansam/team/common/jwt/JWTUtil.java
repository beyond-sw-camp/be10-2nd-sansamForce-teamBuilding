package sansam.team.common.jwt;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import sansam.team.user.command.dto.JwtToken;
import sansam.team.user.command.entity.User;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.stream.Collectors;

@Slf4j
@Component
public class JWTUtil {

    private final SecretKey secretKey;

    public JWTUtil(@Value("${JWT_SECRET_KEY}") String secret) {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        this.secretKey = Keys.hmacShaKeyFor(keyBytes);
    }

    // JWT 생성 메서드 (User 객체를 매개변수로 사용)
    public JwtToken createToken(User user) throws JsonProcessingException {
        // 사용자 권한 정보 설정
        String authorities = user.getAuthorities().stream()
                .map(authority -> authority.getAuthority())
                .collect(Collectors.joining(","));

        // Access Token 생성
        String accessToken = Jwts.builder()
                .setSubject(String.valueOf(user.getUserSeq()))  // userSeq를 subject로 설정
                .claim("userId", user.getUserId())
                .claim("userName", user.getUserName())
                .claim("auth", authorities)  // 권한 정보 추가
                .setIssuedAt(new Date())  // iat 추가 (발행 시간)
                .setExpiration(new Date((new Date()).getTime() + 86400000))  // 만료 시간 (1일)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();

        // Refresh Token 생성 (7일 만료)
        String refreshToken = Jwts.builder()
                .setIssuedAt(new Date())  // iat 추가 (발행 시간)
                .setExpiration(new Date((new Date()).getTime() + 604800000))  // 만료 시간 (7일)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();

        // JWT 토큰 반환
        return JwtToken.builder()
                .grantType("Bearer")
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    // JWT 토큰에서 userSeq 추출 (subject에서 userSeq를 파싱)
    public Long getUserSeqFromToken(String token) {
        try {
            String subject = Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();

            // 로그 추가: 파싱된 subject 값 확인
            log.info("Parsed JWT subject (userSeq): {}", subject);

            return Long.valueOf(subject);  // subject는 userSeq를 의미
        } catch (ExpiredJwtException e) {
            log.error("Expired JWT token", e);
        } catch (UnsupportedJwtException e) {
            log.error("Unsupported JWT token", e);
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token", e);
        } catch (SignatureException e) {
            log.error("Invalid JWT signature", e);
        } catch (IllegalArgumentException e) {
            log.error("JWT token is null or empty", e);
        }
        return null;
    }

    // 토큰에서 권한 정보 파싱
    public String getAuthFromToken(String token) {
        Claims claims = parseClaims(token);
        return claims != null ? claims.get("auth", String.class) : null;
    }

    // 토큰의 Claims 파싱
    private Claims parseClaims(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (JwtException e) {
            log.error("Invalid JWT token", e);
            return null;
        }
    }

    // 토큰 유효성 검증
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            log.error("Invalid JWT token", e);
            return false;
        }
    }
}
