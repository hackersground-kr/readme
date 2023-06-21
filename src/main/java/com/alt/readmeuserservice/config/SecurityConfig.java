package com.alt.readmeuserservice.config;

import com.alt.readmeuserservice.CookieProvider;
import com.alt.readmeuserservice.JwtTokenProvider;
import com.alt.readmeuserservice.filter.JwtAuthenticationFilter;
import com.alt.readmeuserservice.service.impl.RefreshTokenServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtTokenProvider jwtTokenProvider;
    private final RefreshTokenServiceImpl refreshTokenServiceImpl;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final CookieProvider cookieProvider;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .httpBasic().disable()
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeHttpRequests()
            .anyRequest().permitAll()

            .and().addFilterBefore(new JwtAuthenticationFilter(
                authenticationManagerBuilder,
                jwtTokenProvider,
                refreshTokenServiceImpl,
                cookieProvider)
                , UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
