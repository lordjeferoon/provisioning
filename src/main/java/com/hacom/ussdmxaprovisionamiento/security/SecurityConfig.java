package com.hacom.ussdmxaprovisionamiento.security;

import com.hacom.ussdmxaprovisionamiento.metric.MetricService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.AuthenticationWebFilter;
import org.springframework.security.web.server.context.ServerSecurityContextRepository;
import org.springframework.security.web.server.context.WebSessionServerSecurityContextRepository;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    private final MetricService metricService;

    public SecurityConfig(MetricService metricService) {
        this.metricService = metricService;
    }

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return   http
                .csrf().disable()
                .authorizeExchange()
                    .pathMatchers("/public/**").permitAll()
                    .pathMatchers("/cbe-gw/**").authenticated()
                .anyExchange().permitAll()
                .and()
                .addFilterBefore(apiKeyAuthenticationFilter(), SecurityWebFiltersOrder.AUTHENTICATION)
                .exceptionHandling()
                    .authenticationEntryPoint((exchange, exception) -> {
                        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                        return exchange.getResponse().setComplete();
                    })
                    .accessDeniedHandler((exchange, exception) -> {
                        exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
                        return exchange.getResponse().setComplete();
                    })
                .and()
                .build();
    }

    @Bean
    public ServerSecurityContextRepository securityContextRepository() {
        return new WebSessionServerSecurityContextRepository();
    }

    @Bean
    public AuthenticationWebFilter apiKeyAuthenticationFilter() {
        return new ApiKeyAuthenticationFilter(metricService);
    }

}
