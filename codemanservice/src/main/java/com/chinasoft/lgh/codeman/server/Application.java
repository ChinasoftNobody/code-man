package com.chinasoft.lgh.codeman.server;

import com.chinasoft.lgh.codeman.server.config.CodeManAuditorAware;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableMongoAuditing(auditorAwareRef = "myAuditorProvider")
@EnableConfigurationProperties
@EnableAuthorizationServer
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public AuditorAware<String> myAuditorProvider() {
        return new CodeManAuditorAware();
    }
}
