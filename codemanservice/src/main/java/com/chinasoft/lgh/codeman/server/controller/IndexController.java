package com.chinasoft.lgh.codeman.server.controller;

import com.chinasoft.lgh.codeman.server.config.auth.SecurityUtil;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class IndexController {

    @GetMapping("/index")
    public String test(){
        return SecurityUtil.current().getUsername();
    }

    @Secured("ADMIN")
    @GetMapping("/test")
    public String test1(){
        return "hello maysham";
    }
}
