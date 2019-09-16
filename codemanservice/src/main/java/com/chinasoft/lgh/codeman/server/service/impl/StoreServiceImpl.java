package com.chinasoft.lgh.codeman.server.service.impl;

import com.chinasoft.lgh.codeman.server.exception.CodeManException;
import com.chinasoft.lgh.codeman.server.exception.ExceptionCode;
import com.chinasoft.lgh.codeman.server.model.MProject;
import com.chinasoft.lgh.codeman.server.model.MStore;
import com.chinasoft.lgh.codeman.server.pojo.store.StoreAddRequest;
import com.chinasoft.lgh.codeman.server.pojo.store.StoreListRequest;
import com.chinasoft.lgh.codeman.server.pojo.store.UrlTypeEnum;
import com.chinasoft.lgh.codeman.server.repo.ProjectRepo;
import com.chinasoft.lgh.codeman.server.repo.StoreRepo;
import com.chinasoft.lgh.codeman.server.service.StoreService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StoreServiceImpl implements StoreService {

    @Resource
    private StoreRepo storeRepo;

    @Resource
    private ProjectRepo projectRepo;

    @Override
    public Page<MStore> findProjectStores(StoreListRequest request) {
        return storeRepo.findByProjectId(request.getProjectId(), PageRequest.of(request.getPage(), request.getSize()));
    }

    @Override
    public MStore add(StoreAddRequest request) {
        MProject project = projectRepo.findByIdAndDeleted(request.getProjectId(), false);
        if (project == null){
            throw new CodeManException(ExceptionCode.INVALID_PROJECT);
        }
        MStore store = new MStore();
        store.setName(request.getName());
        store.setDescription(request.getDescription());
        store.setType(request.getType());
        store.setUsername(request.getUsername());
        store.setPassword(request.getPassword());
        store.setUrl(request.getUrl());
        store.setProject(project);
        store.setUrlType(UrlTypeEnum.HTTPS);
        return storeRepo.insert(store);
    }
}
