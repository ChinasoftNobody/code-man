package com.chinasoft.lgh.codeman.service.service;

import com.chinasoft.lgh.iam.core.model.MProject;
import com.chinasoft.lgh.iam.core.pojo.project.ProjectListRequest;
import com.chinasoft.lgh.iam.core.pojo.project.ProjectRegisterRequest;
import org.springframework.data.domain.Page;

public interface ProjectService {

    Page<MProject> queryProjectList(ProjectListRequest request);

    MProject createProject(ProjectRegisterRequest request);
}
