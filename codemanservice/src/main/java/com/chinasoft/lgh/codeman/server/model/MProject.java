package com.chinasoft.lgh.codeman.server.model;

import lombok.Data;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("project")
public class MProject {
    @Id
    private String id;
    private String name;

    @DBRef
    private List<MUser> userList;

    @DBRef
    private List<MUser> adminList;

    @CreatedDate
    private long createdOn;

    @LastModifiedDate
    private long updatedOn;

    @CreatedBy
    private String createdBy;
    @LastModifiedBy
    private String modifiedBy;

    private boolean deleted;
}
