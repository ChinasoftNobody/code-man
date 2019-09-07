package com.chinasoft.lgh.codeman.server.pojo.user;

import lombok.Data;

@Data
public class SortRequest {
    private String direction;
    private String[] props;
}
