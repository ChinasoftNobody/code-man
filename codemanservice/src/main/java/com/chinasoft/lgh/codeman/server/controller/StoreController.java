package com.chinasoft.lgh.codeman.server.controller;

import com.chinasoft.lgh.codeman.server.common.Response;
import com.chinasoft.lgh.codeman.server.model.MStore;
import com.chinasoft.lgh.codeman.server.pojo.store.StoreAddRequest;
import com.chinasoft.lgh.codeman.server.pojo.store.StoreListRequest;
import com.chinasoft.lgh.codeman.server.service.StoreService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/store")
public class StoreController {
    @Resource
    private StoreService storeService;

    @PostMapping("/list")
    public Response<Page<MStore>> list(@RequestBody @Valid StoreListRequest request){
        return Response.of(storeService.findProjectStores(request));
    }
    @PostMapping("/add")
    public Response<MStore> add(@RequestBody @Valid StoreAddRequest request){
        return Response.of(storeService.add(request));
    }
}
