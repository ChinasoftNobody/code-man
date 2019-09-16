package com.chinasoft.lgh.codeman.server.pojo.store;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class StoreAddRequest {
    @NotNull
    private String projectId;
    @NotNull
    private String name;
    private String description;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private StoreTypeEnum type;
    @NotNull
    private String url;
}
