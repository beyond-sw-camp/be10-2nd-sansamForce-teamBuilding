package com.sansam.apigateway.filter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.apache.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

/* API 게이트웨이 요청을 처리하기 전에 JWT 검증 역할 수행 필터 (커스텀 필터) */
@Component
public class AuthorizationHeaderFilter
        extends AbstractGatewayFilterFactory<AuthorizationHeaderFilter.Config> {

    @Value("${JWT_SECRET_KEY}") String secret;

    public AuthorizationHeaderFilter() {
        super(Config.class);
    }

    /* Gateway Filter를 반환하며 exchanger와 chain 객체를 사용하여 요청과 응답 처리 및 다음 필터 실행 */
    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();

            if(!request.getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                return onError(exchange, "Authorization header is missing");
            }

            String bearerToken = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
            if(bearerToken == null || !bearerToken.startsWith("Bearer ")) {
                return onError(exchange, "Invalid or missing Bearer token");
            }

            String jwtToken = bearerToken.substring(7);

            if(!isJwtValid(jwtToken)) {
                return onError(exchange, "Invalid or expired JWT Token");
            }

            return chain.filter(exchange);
        };
    }

    private boolean isJwtValid(String jwtToken) {
        try {
            byte[] keyBytes = Decoders.BASE64.decode(secret);
            SecretKey secretKey = Keys.hmacShaKeyFor(keyBytes);

            String subject = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(jwtToken)
                    .getBody()
                    .getSubject();

            if(subject == null || subject.isEmpty()) {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    /* Mono는 0 or 1의 객체를 비동기적으로 처리할 때 사용 (비동기 작업의 성공 or 실패를 나타내기 위한 반환 타입) */
    private Mono<Void> onError(ServerWebExchange exchange, String errorMessage) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.UNAUTHORIZED);

        /* 상태코드만 설정해서 에러 발생 시 바로 응답 처리 할 경우 */
        // return response.setComplete();
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        String responseBody = "{\"error\":\"" + errorMessage + "\"}";
        DataBufferFactory bufferFactory = response.bufferFactory();
        DataBuffer buffer = bufferFactory.wrap(responseBody.getBytes(StandardCharsets.UTF_8));
        return response.writeWith(Mono.just(buffer));
    }

    public static class Config {}
}
