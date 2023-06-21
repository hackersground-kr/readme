package com.alt.readmeuserservice.service.impl;

import com.alt.readmeuserservice.domain.user.User;
import com.alt.readmeuserservice.domain.user.UserForSecurity;
import com.alt.readmeuserservice.mapper.UserMapper;
import com.alt.readmeuserservice.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailServiceImpl implements CustomUserDetailsService {
    private final UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.getByEmail(username);
        if (user != null) {
            return UserForSecurity.builder()
                    .user(user)
                    .build();
        } else {
            throw new UsernameNotFoundException(username);
        }
    }
}
