package com.alt.readmeuserservice.service.impl;

import com.alt.readmeuserservice.domain.user.User;
import com.alt.readmeuserservice.exception.GlobalException;
import com.alt.readmeuserservice.mapper.UserMapper;
import com.alt.readmeuserservice.service.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    @Override
    public void createRefreshToken(String email, String uuid) {
        User user = userMapper.getByEmail(email);
        if(user == null) throw new GlobalException(HttpStatus.BAD_REQUEST, "can't not found " + email);

        redisTemplate.opsForValue().set("refresh:" + uuid, email);
        redisTemplate.expire("refresh:" + uuid, refresh_expired_time, TimeUnit.MILLISECONDS);
    }
}