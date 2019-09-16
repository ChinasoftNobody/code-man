package com.chinasoft.lgh.codeman.server.pojo.user;

import lombok.Data;

@Data
public class CodeManPageRequest {
    private int page = 0;
    private int size = 10;
}
