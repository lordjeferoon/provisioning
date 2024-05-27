package com.hacom.ussdmxaprovisionamiento.security;

import com.hacom.ussdmxaprovisionamiento.metric.MetricService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.server.authentication.AuthenticationWebFilter;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Collections;

//@Log4j2
/*public class ApiKeyAuthenticationFilter extends AuthenticationWebFilter {

    private static final String API_GW_KEY_UNIQUE = "$H@c0M2023G@t3waY$";
    private static final String API_GW_KEY_NAME = "API-GATEWAY-HEADER-HACOM";
    private final MetricService metricService;

    public ApiKeyAuthenticationFilter(MetricService metricService) {
        super(new SimpleReactiveAuthenticationManager());
        this.metricService = metricService;
    }

    protected Mono<Authentication> convert(ServerWebExchange exchange) {
        String apiKey = extractApiKey(exchange.getRequest().getHeaders());
        if (API_GW_KEY_UNIQUE.equals(apiKey)) {
            Authentication authentication = new ApiKeyAuthentication(apiKey, Collections.emptyList());
            return Mono.just(authentication);
        } else {
            return Mono.error(new BadCredentialsException("Invalid API Key"));
        }
    }

    private String extractApiKey(HttpHeaders headers) {
        String authorizationHeader = headers.getFirst(API_GW_KEY_NAME);
        if (authorizationHeader != null) {
            return authorizationHeader;
        } else {
            throw new BadCredentialsException("Invalid authorization header");
        }
    }

}*/

public class ApiKeyAuthenticationFilter {
	
}
