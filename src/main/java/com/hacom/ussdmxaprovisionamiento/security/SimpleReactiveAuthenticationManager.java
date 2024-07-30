package com.hacom.ussdmxaprovisionamiento.security;

import lombok.extern.log4j.Log4j2;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.ReactiveAuthenticationManager;
//import org.springframework.security.core.Authentication;
import reactor.core.publisher.Mono;

public class SimpleReactiveAuthenticationManager {
//@Log4j2
//public class SimpleReactiveAuthenticationManager implements ReactiveAuthenticationManager {

    /*@Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        String apiKey = (String) authentication.getPrincipal();
        if (isValidApiKey(apiKey)) {
            return Mono.just(authentication);
        } else {
            return Mono.error(new BadCredentialsException("Invalid API Key"));
        }
    }

    private boolean isValidApiKey(String apiKey) {
        return apiKey != null && apiKey.equals("claveApiVálida");
    }*/
}