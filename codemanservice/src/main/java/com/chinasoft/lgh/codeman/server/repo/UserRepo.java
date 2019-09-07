package com.chinasoft.lgh.codeman.server.repo;

import com.chinasoft.lgh.codeman.server.model.MUser;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserRepo extends IamRepo<MUser, String> {
    MUser findByUsernameAndDeleted(String name, boolean deleted);

    Page<MUser> findAllByDeleted(boolean deleted, Pageable pageable);

    Page<MUser> findByDeleted(boolean deleted, Example<MUser> example, Pageable pageable);
}
