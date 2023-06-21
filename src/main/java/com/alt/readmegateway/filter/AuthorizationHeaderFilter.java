package com.alt.readmegateway.filter;

import com.alt.readmegateway.entity.TokenInfo;
import com.alt.readmegateway.security.JwtTokenProvider;
import com.alt.readmegateway.service.RefreshTokenService;
import com.alt.readmegateway.util.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class AuthorizationHeaderFilter extends AbstractGatewayFilterFactory<AuthorizationHeaderFilter.Config> {

    private final Environment environment;
    private final JwtTokenProvider jwtTokenProvider;
    private final CookieUtil cookieUtil;
    private final RefreshTokenService refreshTokenService;

    public AuthorizationHeaderFilter(Environment environment, JwtTokenProvider jwtTokenProvider, CookieUtil cookieUtil, RefreshTokenService refreshTokenService) {
        super(Config.class);
        this.environment = environment;
        this.jwtTokenProvider = jwtTokenProvider;
        this.cookieUtil = cookieUtil;
        this.refreshTokenService = refreshTokenService;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();

            String accessToken = null;
            String refreshToken = null;

            if(cookieUtil.checkCookie(request, "access-token")) accessToken = cookieUtil.getCookie(request, "access-token");
            if(cookieUtil.checkCookie(request, "refresh-token")) refreshToken = cookieUtil.getCookie(request, "refresh-token");

            if(accessToken == null && refreshToken == null) {
                return onError(exchange, "token not found", HttpStatus.UNAUTHORIZED);
            }

            ServerHttpRequest newRequest;
            String subject = null;
            if (accessToken == null || jwtTokenProvider.validateJwtToken(accessToken)) {
                TokenInfo tokenInfo = refreshTokenService.refresh(jwtTokenProvider.getUserId(refreshToken));
                exchange.getResponse().addCookie(cookieUtil.createAccessTokenCookie(tokenInfo.getAccess()));
                exchange.getResponse().addCookie(cookieUtil.createRefreshTokenCookie(tokenInfo.getRefresh()));
                //return onError(exchange, "No Access Token", HttpStatus.UNAUTHORIZED);
            } else {
                subject = jwtTokenProvider.getUserId(accessToken);

                if (subject.equals("feign")) return chain.filter(exchange);

                if (!jwtTokenProvider.getRoles(accessToken).contains("ROLE_USER")) {
                    return onError(exchange, "No Access", HttpStatus.UNAUTHORIZED);
                }
            }
            newRequest = request.mutate()
                    .header("sender", subject)
                    .build();

            return chain.filter(exchange.mutate().request(newRequest).build());
        };
    }

    private Mono<Void> onError(ServerWebExchange exchange, String errorMsg, HttpStatus httpStatus) {
        log.error(errorMsg);

        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(httpStatus);

        return response.setComplete();
    }

    public static class Config {

    }
}
