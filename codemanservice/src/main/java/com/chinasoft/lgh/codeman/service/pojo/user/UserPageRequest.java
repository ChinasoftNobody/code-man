package com.chinasoft.lgh.codeman.service.pojo.user;

import lombok.Data;

@Data
public class UserPageRequest {
    private int size;
    private int number;
    private String keyword;
    private SortRequest sort;
}
