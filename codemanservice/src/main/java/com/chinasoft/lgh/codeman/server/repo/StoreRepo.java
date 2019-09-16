package com.chinasoft.lgh.codeman.server.repo;

import com.chinasoft.lgh.codeman.server.model.MStore;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StoreRepo extends CodeManRepo<MStore, String> {

    Page<MStore> findByProjectId(String projectId, Pageable pageable);
}
