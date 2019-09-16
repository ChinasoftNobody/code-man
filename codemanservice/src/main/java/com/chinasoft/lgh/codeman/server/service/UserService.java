package com.chinasoft.lgh.codeman.server.service;

import com.chinasoft.lgh.codeman.server.model.MUser;
import com.chinasoft.lgh.codeman.server.model.MUserProject;

import java.util.List;

public interface UserService {

    MUser queryByUsername(String username);

    MUser createUser(String username, String password);

    List<MUserProject> queryUserProjects(String userId);
}
