package com.chinasoft.lgh.codeman.service.service;

import com.chinasoft.lgh.codeman.service.model.MUser;
import com.chinasoft.lgh.codeman.service.pojo.user.UserInfo;
import com.chinasoft.lgh.codeman.service.pojo.user.UserPageRequest;
import org.springframework.data.domain.Page;

public interface UserService {

    MUser validateToken(String token);

    MUser login(UserInfo userParam);

    MUser register(UserInfo userInfo);

    MUser updateBasicInfo(UserInfo userInfo);

    void logout(MUser user);

    Page<MUser> queryUserList(UserPageRequest request);
}
