package com.chinasoft.lgh.codeman.server.service.impl;

import com.chinasoft.lgh.codeman.server.exception.CodeManException;
import com.chinasoft.lgh.codeman.server.exception.ExceptionCode;
import com.chinasoft.lgh.codeman.server.model.MUser;
import com.chinasoft.lgh.codeman.server.model.MUserProject;
import com.chinasoft.lgh.codeman.server.repo.UserProjectRepo;
import com.chinasoft.lgh.codeman.server.repo.UserRepo;
import com.chinasoft.lgh.codeman.server.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepo userRepo;

    @Resource
    private UserProjectRepo userProjectRepo;

    @Override
    public MUser queryByUsername(String username) {
        return userRepo.findByUsernameAndDeleted(username, false);
    }

    @Override
    public MUser createUser(String username, String password) {
        if (userRepo.findByUsernameAndDeleted(username, false) != null) {
            throw new CodeManException(ExceptionCode.USER_READY_EXIST);
        }
        MUser user = new MUser(username, new BCryptPasswordEncoder().encode(password));
        return userRepo.save(user);
    }

    @Override
    public List<MUserProject> queryUserProjects(String userId) {
        return userProjectRepo.findByUserId(userId);
    }
}
