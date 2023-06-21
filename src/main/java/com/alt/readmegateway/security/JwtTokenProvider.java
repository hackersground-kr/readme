package com.alt.readmegateway.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class JwtTokenProvider {
    private final Key SECRET;
    private final Long ACCESS_EXPIRED_TIME;
    private final Long REFRESH_EXPIRED_TIME;

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


    public String getUserId(String token) {
        return getClaimsFromJwtToken(token).getSubject();
    }

    private Claims getClaimsFromJwtToken(String token) {
        try {
            return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }

    public String getRefreshTokenId(String token) {
        return getClaimsFromJwtToken(token).get("value").toString();
    }

    public String generateAccessToken(String userName, String uri, List<String> roles) {
        Claims claims = Jwts.claims().setSubject(userName);
        claims.put("roles", roles);

        return Jwts.builder()
                .addClaims(claims)
                .setExpiration(
                        new Date(System.currentTimeMillis() + ACCESS_EXPIRED_TIME)  // (100일) 1시간
                )
                .setIssuedAt(new Date())
                .signWith(SECRET, SignatureAlgorithm.HS256)
                .setIssuer(uri)
                .compact();
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

    public List<String> getRoles(String token) {
        return (List<String>) getClaimsFromJwtToken(token).get("roles");
    }

    public boolean validateJwtToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
        } catch (SignatureException | MalformedJwtException |
                 UnsupportedJwtException | IllegalArgumentException | ExpiredJwtException jwtException) {
            return true;
        }
        return false;
    }

    public boolean equalRefreshTokenId(String refreshTokenId, String refreshToken) {
        String compareToken = this.getRefreshTokenId(refreshToken);
        return refreshTokenId.equals(compareToken);
    }

}