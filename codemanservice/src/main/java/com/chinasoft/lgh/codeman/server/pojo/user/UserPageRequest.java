package com.chinasoft.lgh.codeman.server.pojo.user;

import lombok.Data;

@Data
public class UserPageRequest {
    private int size;
    private int number;
    private String keyword;
    private SortRequest sort;
}
