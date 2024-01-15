package com.zenit.spellcheck.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    /* Ip 0:0:0:0:0:0:0:1 is given for development purposes locally otherwise in cloud
    * environment it must be taken real ip of the device */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .antMatchers(HttpMethod.GET, "/api/v1/spell-check/match")
                                .hasIpAddress("0:0:0:0:0:0:0:1")
                                .antMatchers("/api/v1/spell-check/**")
                                .permitAll()
                );

        return http.build();

    }

}
