package com.chinasoft.lgh.codeman.server.external.github;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.bson.internal.Base64;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

public class GithubRestTemplate extends RestTemplate {
    private String username;
    private String password;

    private GithubRestTemplate(String username, String password) {
        this.username = username;
        this.password = password;
        String auth = String.join(":", this.username, this.password);
        String encodedAuth = Base64.encode(auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic " + encodedAuth;
        List<BasicHeader> headers = Collections.singletonList(new BasicHeader("Authorization", authHeader));
        CloseableHttpClient client = HttpClients.custom().setDefaultHeaders(headers).build();
        setRequestFactory(new HttpComponentsClientHttpRequestFactory(client));
    }


    public static GithubRestTemplate newOne(String username, String password) {
        return new GithubRestTemplate(username, password);
    }

}
