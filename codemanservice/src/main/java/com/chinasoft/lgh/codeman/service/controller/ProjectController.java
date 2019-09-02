package com.chinasoft.lgh.codeman.service.controller;

import com.chinasoft.lgh.codeman.service.config.Constants;
import com.chinasoft.lgh.codeman.service.exception.ExceptionCode;
import com.chinasoft.lgh.codeman.service.exception.IamException;
import com.chinasoft.lgh.codeman.service.model.MProject;
import com.chinasoft.lgh.codeman.service.pojo.Response;
import com.chinasoft.lgh.codeman.service.pojo.project.ProjectListRequest;
import com.chinasoft.lgh.codeman.service.pojo.project.ProjectRegisterRequest;
import com.chinasoft.lgh.codeman.service.service.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/project", headers = {Constants.IAM_TOKEN_HEADER},
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ProjectController {
    @Resource
    private ProjectService projectService;

    @PostMapping("/list")
    public Response<Page<MProject>> projectList(@RequestBody ProjectListRequest request) {
        return Response.success(projectService.queryProjectList(request));
    }
    @PostMapping("/create")
    public Response<MProject> create(@RequestBody ProjectRegisterRequest request){
        MProject project = projectService.createProject(request);
        if (project != null){
            return Response.success(project);
        }
        throw new IamException(ExceptionCode.PROJECT_CREATE_FAILED);
    }

}
