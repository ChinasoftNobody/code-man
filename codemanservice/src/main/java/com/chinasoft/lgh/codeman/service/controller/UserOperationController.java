package com.chinasoft.lgh.codeman.service.controller;

import com.chinasoft.lgh.iam.core.config.Constants;
import com.chinasoft.lgh.iam.core.model.MUser;
import com.chinasoft.lgh.iam.core.pojo.Response;
import com.chinasoft.lgh.iam.core.pojo.user.UserInfo;
import com.chinasoft.lgh.iam.core.pojo.user.UserPageRequest;
import com.chinasoft.lgh.iam.core.service.UserService;
import com.chinasoft.lgh.iam.core.util.TokenStore;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/user", headers = {Constants.IAM_TOKEN_HEADER},
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserOperationController {
    @Resource
    private UserService userService;

    @PostMapping("/update")
    public Response<MUser> update(@RequestBody UserInfo userInfo) {
        MUser user = userService.updateBasicInfo(userInfo);
        return Response.success(user);
    }

    @PostMapping("/list")
    public Response<Page<MUser>> getUserList(@RequestBody UserPageRequest request) {
        return Response.success(userService.queryUserList(request));
    }

    @PostMapping("/logout")
    public Response<String> logout() {
        MUser user = TokenStore.currentUser.get();
        userService.logout(user);
        return Response.success("ok");
    }
}
