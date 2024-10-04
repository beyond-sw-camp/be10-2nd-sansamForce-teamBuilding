package com.sansam.team.common.util;

import com.sansam.team.common.aggregate.RoleType;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.crypto.SecretKey;

@Component
public class SecurityUtil {

    @Value("${JWT_SECRET_KEY}") String secret;

    public CustomUserDTO getAuthenticatedUser() {
        /* 현재 요청의 Http Servlet Request 를 가져옴 */
        ServletRequestAttributes requestAttributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        if(requestAttributes != null) {

            /* 현재 요청의 Authorization 헤더 추출 (Bearer 토큰) */
            String bearerToken = requestAttributes
                    .getRequest()           // request 객체 추출
                    .getHeader(HttpHeaders.AUTHORIZATION);
            String token = bearerToken.substring(7);

            return getCustomUserDTO(token);
        }

        return null;
    }

    /* Token에서 Claims 추출 */
    public Claims parseClaims(String token) {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        SecretKey secretKey = Keys.hmacShaKeyFor(keyBytes);

        return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody();
    }

    /* Token에서 사용자의 id(subject 클레임) 추출 */
    public CustomUserDTO getCustomUserDTO(String token) {
        Claims claims = parseClaims(token);
        CustomUserDTO customUserDTO = new CustomUserDTO();
        customUserDTO.setUserSeq(Long.parseLong(claims.getSubject()));
        customUserDTO.setUserId((String) claims.get("userId"));
        customUserDTO.setRoleType((RoleType) claims.get("auth"));

        return customUserDTO;
    }
}
