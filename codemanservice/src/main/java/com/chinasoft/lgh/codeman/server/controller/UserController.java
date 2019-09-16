package com.chinasoft.lgh.codeman.server.controller;

import com.chinasoft.lgh.codeman.server.common.Response;
import com.chinasoft.lgh.codeman.server.model.MUserProject;
import com.chinasoft.lgh.codeman.server.service.UserService;
import com.chinasoft.lgh.codeman.server.util.TokenStore;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/user",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/projects")
    public Response<List<MUserProject>> userProjects() {
        return Response.of(userService.queryUserProjects(TokenStore.currentUser().getId()));
    }
}
