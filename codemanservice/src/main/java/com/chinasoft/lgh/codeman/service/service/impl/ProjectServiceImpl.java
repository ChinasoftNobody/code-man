package com.chinasoft.lgh.codeman.service.service.impl;

import com.chinasoft.lgh.iam.core.model.MProject;
import com.chinasoft.lgh.iam.core.pojo.project.ProjectListRequest;
import com.chinasoft.lgh.iam.core.pojo.project.ProjectRegisterRequest;
import com.chinasoft.lgh.iam.core.repo.ProjectRepo;
import com.chinasoft.lgh.iam.core.service.ProjectService;
import com.chinasoft.lgh.iam.core.util.TokenStore;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Collections;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Resource
    private ProjectRepo projectRepo;

    @Override
    public MProject createProject(ProjectRegisterRequest request) {
        if (request != null && StringUtils.isEmpty(request.getName())){
            MProject project = new MProject();
            project.setName(request.getName());
            project.setAdminList(Collections.singletonList(TokenStore.currentUser.get()));
            return projectRepo.insert(project);
        }
        return null;
    }

    @Override
    public Page<MProject> queryProjectList(ProjectListRequest request) {
        return projectRepo.findAll(PageRequest.of(request.getPage(), request.getSize()));
    }
}
