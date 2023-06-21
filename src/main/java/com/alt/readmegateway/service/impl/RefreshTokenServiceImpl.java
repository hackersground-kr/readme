package com.alt.readmegateway.service.impl;

import com.alt.readmegateway.entity.TokenInfo;
import com.alt.readmegateway.entity.User;
import com.alt.readmegateway.exception.GlobalException;
import com.alt.readmegateway.mapper.UserMapper;
import com.alt.readmegateway.security.JwtTokenProvider;
import com.alt.readmegateway.service.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

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
    public TokenInfo refresh(String uuid) {
        String email = (String) redisTemplate.opsForValue().get("refresh:" + uuid);
        log.info(uuid + " " + email);
        User user = userMapper.getByEmail(email);
        redisTemplate.delete("refresh:" + uuid);

        String refreshId = UUID.randomUUID().toString();
        List<String> authorities = new ArrayList<>();

        authorities.add("ROLE_USER");
        if(user.getType().equals('S')) {
            authorities.add("ROLE_STUDENT");
        }
        else if(user.getType().equals('A')) {
            authorities.add("ROLE_SCHOOL");
        }
        else if(user.getType().equals('E')) {
            authorities.add("ROLE_ENTERPRISE");
        }

        TokenInfo tokenInfo = TokenInfo.builder()
                .access(jwtTokenProvider.generateAccessToken(
                                    email,
                                null,
                                    authorities
                        )
                )
                .refresh(jwtTokenProvider.generateRefreshToken(refreshId))
                .build();
        createRefreshToken(email, refreshId);

        return tokenInfo;
    }
}