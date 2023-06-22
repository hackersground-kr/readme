package com.alt.readsearchservice;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.List;

@Log4j2
@Component
public class JwtTokenProvider {
    private final Long ACCESS_EXPIRED_TIME;

    private final Long REFRESH_EXPIRED_TIME;

    private final Key SECRET;

    public JwtTokenProvider(
            @Value("${token.secret}") String secretKey
            , @Value("${token.access-expired-time}") Long access_expired_time
            , @Value("${token.refresh-expired-time}") Long refresh_expired_time
    ) {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        this.SECRET = Keys.hmacShaKeyFor(keyBytes);
        this.ACCESS_EXPIRED_TIME = access_expired_time;
        this.REFRESH_EXPIRED_TIME = refresh_expired_time;
    }

    // 유저 정보를 가지고 AccessToken, RefreshToken 을 생성하는 메서드
    public String generateAccessToken(String userName, List<String> roles) {
        Claims claims = Jwts.claims().setSubject(userName);
        claims.put("roles", roles);

        return Jwts.builder()
                .addClaims(claims)
                .setExpiration(
                        new Date(System.currentTimeMillis() + ACCESS_EXPIRED_TIME)  // (100일) 1시간
                )
                .setIssuedAt(new Date())
                .signWith(SECRET, SignatureAlgorithm.HS256)
                .compact();
    }

    public Date getTokenExpiredTime(String token) {
        return new Date(Long.parseLong(String.valueOf(getClaimsFromJwtToken(token).get("exp"))));
    }

    public String generateRefreshToken(String uuid) {
        Claims claims = Jwts.claims().setSubject(uuid);

        return Jwts.builder()
                .addClaims(claims)
                .setExpiration(
                        new Date(System.currentTimeMillis() + REFRESH_EXPIRED_TIME)  // (100일) 1시간
                )
                .setIssuedAt(new Date())
                .signWith(SECRET, SignatureAlgorithm.HS256)
                .compact();
    }

    public String getUserId(String token) {
        return getClaimsFromJwtToken(token).getSubject();
    }

    public String getTokenId(String token) {
        return getClaimsFromJwtToken(token).getSubject();
    }

    public List<String> getRoles(String token) {
        return (List<String>) getClaimsFromJwtToken(token).get("roles");
    }

    public void validateJwtToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
        } catch (SignatureException  | MalformedJwtException |
                 UnsupportedJwtException | IllegalArgumentException | ExpiredJwtException jwtException) {
            throw jwtException;
        }
    }

    private Claims getClaimsFromJwtToken(String token) {
        try {
            return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }
}