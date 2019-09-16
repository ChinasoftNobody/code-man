package com.chinasoft.lgh.codeman.server.service.impl;

import com.chinasoft.lgh.codeman.server.config.auth.RoleEnum;
import com.chinasoft.lgh.codeman.server.model.MProject;
import com.chinasoft.lgh.codeman.server.model.MUserProject;
import com.chinasoft.lgh.codeman.server.pojo.project.ProjectListRequest;
import com.chinasoft.lgh.codeman.server.pojo.project.ProjectRegisterRequest;
import com.chinasoft.lgh.codeman.server.repo.ProjectRepo;
import com.chinasoft.lgh.codeman.server.repo.UserProjectRepo;
import com.chinasoft.lgh.codeman.server.service.ProjectService;
import com.chinasoft.lgh.codeman.server.util.TokenStore;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Resource
    private ProjectRepo projectRepo;
    @Resource
    private UserProjectRepo userProjectRepo;

    @Override
    public MProject createProject(ProjectRegisterRequest request) {
        if (request != null && !StringUtils.isEmpty(request.getName())) {
            MProject project = new MProject();
            project.setName(request.getName());
            MProject mProject = projectRepo.insert(project);
            MUserProject userProject = new MUserProject();
            userProject.setUser(TokenStore.currentUser());
            userProject.setProject(mProject);
            userProject.setRole(RoleEnum.PROJECT_CREATOR);
            userProjectRepo.insert(userProject);
            return mProject;
        }
        return null;
    }

    @Override
    public Page<MProject> queryProjectList(ProjectListRequest request) {
        return projectRepo.findAll(PageRequest.of(request.getPage(), request.getSize()));
    }
}
