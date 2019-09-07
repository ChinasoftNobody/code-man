package com.chinasoft.lgh.codeman.server.model;

import com.chinasoft.lgh.codeman.server.pojo.ServiceType;
import lombok.Data;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "server")
public class MService {
    @Id
    private String id;

    private String name;
    private ServiceType type = ServiceType.COMMON;
    private String domain;
    private String home;
    private String target;

    @CreatedBy
    private String createdBy;
    @LastModifiedBy
    private String modifiedBy;
    private boolean deleted;

    @CreatedDate
    private long createdOn;

    @LastModifiedDate
    private long updatedOn;
}
