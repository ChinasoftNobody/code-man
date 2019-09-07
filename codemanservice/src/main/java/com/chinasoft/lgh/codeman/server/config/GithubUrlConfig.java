package com.chinasoft.lgh.codeman.server.config;

import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
@Configuration
@PropertySource("github-url.properties")
@Data
public class GithubUrlConfig {
    private String userInfo;
}
