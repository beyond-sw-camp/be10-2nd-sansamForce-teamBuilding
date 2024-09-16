package sansam.team.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
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
        // 사용자 권한 정보 설정 (예시: ROLE_USER)
        String authorities = user.getAuth().toString();  // user.getAuth()에서 권한을 가져옴

        // Access Token 생성
        String accessToken = Jwts.builder()
                .setSubject(String.valueOf(user.getUserSeq()))
                .claim("userId", user.getId())
                .claim("userName", user.getName())// User의 ID를 subject로 설정
                .claim("auth", authorities)  // 권한 정보를 추가
                .setExpiration(new Date((new Date()).getTime() + 86400000))  // 만료 시간 설정 (1일)
                .signWith(secretKey, SignatureAlgorithm.HS256)  // 서명 알고리즘 및 비밀 키 사용
                .compact();

        // Refresh Token 생성
        String refreshToken = Jwts.builder()
                .setExpiration(new Date((new Date()).getTime() + 86400000))  // 만료 시간 설정 (1일)
                .signWith(secretKey, SignatureAlgorithm.HS256)  // 서명 알고리즘 및 비밀 키 사용
                .compact();

        // JWT 토큰 반환
        return JwtToken.builder()
                .grantType("Bearer")
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    // 토큰 검증 및 subject 반환
    public String validateTokenAndGetSubject(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
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

