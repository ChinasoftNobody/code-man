package com.chinasoft.lgh.codeman.server.external.github.impl;

import com.chinasoft.lgh.codeman.server.config.GithubUrlConfig;
import com.chinasoft.lgh.codeman.server.external.github.GithubRestTemplate;
import com.chinasoft.lgh.codeman.server.external.github.GithubService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class GithubServiceImpl implements GithubService {

    @Value("${github.host}")
    private String host;

    @Resource
    private GithubUrlConfig config;

    @Override
    public void queryUser(String username, String password) {
        ResponseEntity<String> forEntity = GithubRestTemplate.newOne(username, password).getForEntity(host + config.getUserInfo(), String.class);
        System.out.println(forEntity.getBody());
    }
}
