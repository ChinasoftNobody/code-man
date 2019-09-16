package com.chinasoft.lgh.codeman.server.model;

import com.chinasoft.lgh.codeman.server.pojo.ServiceType;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "server")
public class MService extends MBaseModel{
    private String name;
    private ServiceType type = ServiceType.COMMON;
    private String domain;
    private String home;
    private String target;
}
