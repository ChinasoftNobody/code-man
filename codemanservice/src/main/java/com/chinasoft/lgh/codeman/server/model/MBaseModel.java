package com.chinasoft.lgh.codeman.server.model;

import lombok.Data;
import org.springframework.data.annotation.*;

@Data
public class MBaseModel {

    @Id
    private String id;

    private boolean deleted;

    @CreatedDate
    private long createdOn;

    @LastModifiedDate
    private long updatedOn;

    @CreatedBy
    private String createdBy;

    @LastModifiedBy
    private String modifiedBy;
}
