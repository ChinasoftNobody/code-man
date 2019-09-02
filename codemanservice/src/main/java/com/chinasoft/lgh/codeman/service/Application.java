package com.chinasoft.lgh.codeman.service;

import com.chinasoft.lgh.codeman.service.config.IamAuditorAware;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableMongoAuditing(auditorAwareRef = "myAuditorProvider")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public AuditorAware<String> myAuditorProvider() {
        return new IamAuditorAware();
    }
}
