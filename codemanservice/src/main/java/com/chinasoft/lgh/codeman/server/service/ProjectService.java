package com.chinasoft.lgh.codeman.server.service;

import com.chinasoft.lgh.codeman.server.model.MProject;
import com.chinasoft.lgh.codeman.server.pojo.project.ProjectListRequest;
import com.chinasoft.lgh.codeman.server.pojo.project.ProjectRegisterRequest;
import org.springframework.data.domain.Page;

public interface ProjectService {

    Page<MProject> queryProjectList(ProjectListRequest request);

    MProject createProject(ProjectRegisterRequest request);
}
