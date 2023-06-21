package com.alt.readmegateway.util;

import com.alt.readmegateway.exception.GlobalException;
import jakarta.servlet.http.Cookie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import java.util.Objects;

@Component
@Slf4j
public class CookieUtil {
    @Value("${token.refresh-expired-time}")
    private String refreshTokenExpiredTime;
    @Value("${token.access-expired-time}")
    private String accessTokenExpiredTime;

    public ResponseCookie createRefreshTokenCookie(String refreshToken) {
        return ResponseCookie.from("refresh-token", refreshToken)
                .httpOnly(true)
                .secure(false)
                .path("/")
                .maxAge(Long.parseLong(refreshTokenExpiredTime)).build();
    }

    public ResponseCookie createAccessTokenCookie(String accessToken) {
        return ResponseCookie.from("access-token", accessToken)
                .httpOnly(true)
                .secure(false)
                .path("/")
                .maxAge(Long.parseLong(accessTokenExpiredTime)).build();
    }

    public Cookie of(ResponseCookie responseCookie) {
        Cookie cookie = new Cookie(responseCookie.getName(), responseCookie.getValue());
        cookie.setPath(responseCookie.getPath());
        cookie.setSecure(responseCookie.isSecure());
        cookie.setHttpOnly(responseCookie.isHttpOnly());
        cookie.setMaxAge((int) responseCookie.getMaxAge().getSeconds());
        return cookie;
    }
    public boolean checkCookie(ServerHttpRequest req, String cookieName) {
        final MultiValueMap<String, HttpCookie> cookies = req.getCookies();
        return cookies.getFirst(cookieName) != null;
    }
    public String getCookie(ServerHttpRequest req, String cookieName) {
        try {
            final MultiValueMap<String, HttpCookie> cookies = req.getCookies();
            return Objects.requireNonNull(cookies.getFirst(cookieName)).getValue();
        } catch (NullPointerException e) {
            throw new GlobalException(HttpStatus.UNAUTHORIZED, "No Access Token");
        }
    }
}