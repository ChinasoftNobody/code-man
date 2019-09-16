package com.chinasoft.lgh.codeman.server.model;

import com.chinasoft.lgh.codeman.server.config.auth.RoleEnum;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "user_project")
public class MUserProject extends MBaseModel{

    @DBRef
    private MProject project;
    @DBRef
    private MUser user;

    private RoleEnum role;

}
