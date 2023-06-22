package com.alt.readmeuserservice.service.impl;

import com.alt.readmeuserservice.CookieProvider;
import com.alt.readmeuserservice.JwtTokenProvider;
import com.alt.readmeuserservice.domain.request.TokenInfo;
import com.alt.readmeuserservice.domain.user.User;
import com.alt.readmeuserservice.domain.user.UserForSecurity;
import com.alt.readmeuserservice.exception.GlobalException;
import com.alt.readmeuserservice.mapper.UserMapper;
import com.alt.readmeuserservice.service.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class RefreshTokenServiceImpl implements RefreshTokenService {
    @Value("${token.refresh-expired-time}")
    private Long refresh_expired_time;
    private final RedisTemplate<String, Object> redisTemplate;
    private final UserMapper userMapper;
    private final JwtTokenProvider jwtTokenProvider;
    private final CookieProvider cookieProvider;

    @Transactional
    @Override
    public void createRefreshToken(String email, String uuid) {
        User user = userMapper.getByEmail(email);
        if(user == null) throw new GlobalException(HttpStatus.BAD_REQUEST, "can't not found " + email);

        redisTemplate.opsForValue().set("refresh:" + uuid, email);
        redisTemplate.expire("refresh:" + uuid, refresh_expired_time, TimeUnit.MILLISECONDS);
    }

    @Transactional
    @Override
    public ResponseEntity<?> refresh(String uuid) {
        String email = (String) redisTemplate.opsForValue().get(uuid);
        redisTemplate.delete(uuid);

        UserForSecurity user = UserForSecurity.builder()
                .user(userMapper.getByEmail(email))
                .build();

        String refreshId = UUID.randomUUID().toString();
        TokenInfo tokenInfo = TokenInfo.builder()
                .access(jwtTokenProvider.generateAccessToken(email,
                                user
                                        .getAuthorities()
                                        .stream()
                                        .map(GrantedAuthority::getAuthority)
                                        .collect(Collectors.toList())
                        )
                )
                .refresh(jwtTokenProvider.generateRefreshToken(refreshId))
                .build();
        createRefreshToken(email, refreshId);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.SET_COOKIE,
                cookieProvider.createAccessTokenCookie(tokenInfo.getAccess()).toString());
        httpHeaders.add(HttpHeaders.SET_COOKIE,
                cookieProvider.createRefreshTokenCookie(tokenInfo.getRefresh()).toString());

        return ResponseEntity.status(200)
                .headers(httpHeaders)
                .body("refresh complete");
    }
}