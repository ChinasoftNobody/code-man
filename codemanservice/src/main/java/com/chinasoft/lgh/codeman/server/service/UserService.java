package com.chinasoft.lgh.codeman.server.service;

import com.chinasoft.lgh.codeman.server.model.MUser;

public interface UserService {

    MUser queryByUsername(String username);

    MUser createUser(String username, String password);
}
