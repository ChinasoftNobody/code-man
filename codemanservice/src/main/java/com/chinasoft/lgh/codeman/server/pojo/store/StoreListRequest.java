package com.chinasoft.lgh.codeman.server.pojo.store;

import com.chinasoft.lgh.codeman.server.pojo.user.CodeManPageRequest;
import lombok.Data;

@Data
public class StoreListRequest extends CodeManPageRequest {
    private String projectId;
}
