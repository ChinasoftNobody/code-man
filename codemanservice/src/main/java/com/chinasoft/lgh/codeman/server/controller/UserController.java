package com.chinasoft.lgh.codeman.server.controller;

import com.chinasoft.lgh.codeman.server.config.Constants;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/user", headers = {Constants.IAM_TOKEN_HEADER},
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

}
