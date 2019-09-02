package com.chinasoft.lgh.codeman.service.controller;

import com.alibaba.fastjson.JSON;
import com.chinasoft.lgh.codeman.service.config.Constants;
import com.chinasoft.lgh.codeman.service.model.MUser;
import com.chinasoft.lgh.codeman.service.pojo.Response;
import com.chinasoft.lgh.codeman.service.pojo.user.UserInfo;
import com.chinasoft.lgh.codeman.service.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/public/user", headers = {Constants.IAM_TOKEN_HEADER},
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public Response<MUser> login(@RequestBody UserInfo user, HttpServletResponse response, @RequestHeader(Constants.IAM_TOKEN_HEADER) String tokenHeader) {
        MUser mUser = userService.validateToken(tokenHeader);
        if (mUser == null) {
            mUser = userService.login(user);
        }
        response.addHeader(Constants.IAM_TOKEN_HEADER, Base64Utils.encodeToString(JSON.toJSONString(mUser).getBytes(Constants.CHARSET)));
        return Response.success(mUser);
    }

    @PostMapping("/register")
    public Response<MUser> register(@Valid @RequestBody UserInfo userInfo, HttpServletResponse response) {
        MUser user = userService.register(userInfo);
        response.setHeader(Constants.IAM_TOKEN_HEADER, Base64Utils.encodeToString(JSON.toJSONString(user).getBytes(Constants.CHARSET)));
        return Response.success(user);
    }
}
