package com.chinasoft.lgh.codeman.server.config.auth;

import com.chinasoft.lgh.codeman.server.exception.CodeManException;
import com.chinasoft.lgh.codeman.server.exception.ExceptionCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import javax.annotation.Resource;

@Slf4j
@Configuration
@EnableResourceServer
public class OAuth2ResourceConfig extends ResourceServerConfigurerAdapter {

    @Resource
    private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;


    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling()
                .authenticationEntryPoint(customAuthenticationEntryPoint)
                .accessDeniedHandler((httpServletRequest, httpServletResponse, e) -> {
                    throw new CodeManException(ExceptionCode.PERMISSION_DENIED);
                })
                .and().requestMatchers().antMatchers("/api/**")
                .and().authorizeRequests().antMatchers("/api/**").authenticated();
    }
}
