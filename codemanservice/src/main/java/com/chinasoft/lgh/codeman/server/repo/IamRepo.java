package com.chinasoft.lgh.codeman.server.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IamRepo<T, ID> extends MongoRepository<T, ID> {
    T findByIdAndDeleted(ID id, boolean deleted);
}
