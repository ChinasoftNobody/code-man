package com.chinasoft.lgh.codeman.server.model;

import com.chinasoft.lgh.codeman.server.pojo.store.StoreTypeEnum;
import com.chinasoft.lgh.codeman.server.pojo.store.UrlTypeEnum;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("store")
public class MStore extends MBaseModel{
    private String name;
    private String description;
    private StoreTypeEnum type;
    private String url;
    private UrlTypeEnum urlType;

    private String username;
    private String password;

    @DBRef
    private MProject project;
}
