package com.chinasoft.lgh.codeman.server.repo;

import com.chinasoft.lgh.codeman.server.model.MUserProject;

import java.util.List;

public interface UserProjectRepo extends CodeManRepo<MUserProject, String> {

    List<MUserProject> findByUserId(String userId);
}
