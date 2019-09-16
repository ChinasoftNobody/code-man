package com.chinasoft.lgh.codeman.server.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("project")
public class MProject extends MBaseModel{

    private String name;
}
