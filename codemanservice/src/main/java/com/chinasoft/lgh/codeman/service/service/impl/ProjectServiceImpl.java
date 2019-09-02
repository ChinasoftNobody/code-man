package com.chinasoft.lgh.codeman.service.service.impl;

import com.chinasoft.lgh.codeman.service.model.MProject;
import com.chinasoft.lgh.codeman.service.pojo.project.ProjectListRequest;
import com.chinasoft.lgh.codeman.service.pojo.project.ProjectRegisterRequest;
import com.chinasoft.lgh.codeman.service.repo.ProjectRepo;
import com.chinasoft.lgh.codeman.service.service.ProjectService;
import com.chinasoft.lgh.codeman.service.util.TokenStore;
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
