package com.chinasoft.lgh.codeman.server.service;

import com.chinasoft.lgh.codeman.server.model.MStore;
import com.chinasoft.lgh.codeman.server.pojo.store.StoreAddRequest;
import com.chinasoft.lgh.codeman.server.pojo.store.StoreListRequest;
import org.springframework.data.domain.Page;

public interface StoreService {

    Page<MStore> findProjectStores(StoreListRequest request);

    MStore add(StoreAddRequest request);
}
