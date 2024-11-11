package com.example.jwt.service;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;

@Slf4j
@Service
public class JwtService {

    private static final String secretKey = "java17SpringBootJWTTokenIssueMethod";

    // JWT Token 생성
    public String createToken(
            Map<String, Object> claims,
            LocalDateTime expiresAt
    ) {
        var key = Keys.hmacShaKeyFor(secretKey.getBytes());

        // LocalDate => Date
        var _expireAt = Date.from(expiresAt.atZone(ZoneId.systemDefault()).toInstant());

        return Jwts.builder()
                .signWith(key, SignatureAlgorithm.HS256)
                .setClaims(claims)
                .setExpiration(_expireAt)
                .compact();
    }

    // JWT Token 검증
    public void validateToken(String token) {
        var key = Keys.hmacShaKeyFor(secretKey.getBytes());

        var parser = Jwts.parserBuilder()
                .setSigningKey(key)
                .build();

        try{
            var result = parser.parseClaimsJws(token);

            result.getBody().entrySet().forEach(value -> {
                log.info("key : {}, value : {}", value.getKey(), value.getValue());
            });
        }catch (Exception e){
            if(e instanceof SignatureException){
                throw new RuntimeException("JWT Token Not Valid Exception");
            }

            else if(e instanceof ExpiredJwtException){
                throw new RuntimeException("JWT Token Expired Exception");
            }

            else{
                throw new RuntimeException("JWT Token Validation Exception");
            }
        }
    }
}
