package com.chinasoft.lgh.codeman.service.service.impl;

import com.alibaba.fastjson.JSON;
import com.chinasoft.lgh.iam.core.config.Constants;
import com.chinasoft.lgh.iam.core.exception.ExceptionCode;
import com.chinasoft.lgh.iam.core.exception.IamException;
import com.chinasoft.lgh.iam.core.model.MUser;
import com.chinasoft.lgh.iam.core.pojo.user.UserInfo;
import com.chinasoft.lgh.iam.core.pojo.user.UserPageRequest;
import com.chinasoft.lgh.iam.core.repo.UserDao;
import com.chinasoft.lgh.iam.core.repo.UserRepo;
import com.chinasoft.lgh.iam.core.service.UserService;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepo userRepo;
    @Resource
    private UserDao userDao;

    @Override
    public MUser validateToken(String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        try {
            MUser user = JSON.parseObject(Base64Utils.decodeFromString(token), MUser.class);
            if (user.isLogged() && System.currentTimeMillis() < user.getLoginTime() + user.getExpireTime()) {
                return user;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public MUser login(UserInfo userParam) {
        if (StringUtils.isEmpty(userParam.getName()) || StringUtils.isEmpty(userParam.getPassword())) {
            throw new IamException(ExceptionCode.INVALID_PARAM);
        }
        MUser user = userRepo.findByNameAndDeleted(userParam.getName(), false);
        if (user == null) {
            throw new IamException(ExceptionCode.USER_NOT_FOUND);
        }
        String password = user.getPassword();
        if (password.equals(Base64Utils.encodeToString(userParam.getPassword().getBytes(Constants.CHARSET)))) {
            user.setLogged(true);
            user.setLoginTime(System.currentTimeMillis());
            if (!StringUtils.isEmpty(userParam.getTarget())) {
                user.setLoginDomain(userParam.getTarget());
            }
            return userRepo.save(user);
        } else {
            throw new IamException(ExceptionCode.LOGIN_FAILED);
        }
    }

    @Override
    public MUser register(UserInfo userInfo) {
        MUser mUser = userRepo.findByNameAndDeleted(userInfo.getName(), false);
        if (mUser != null) {
            throw new IamException(ExceptionCode.USER_READY_EXIST);
        }
        mUser = new MUser(userInfo.getName(), Base64Utils.encodeToString(userInfo.getPassword().getBytes(Constants.CHARSET))
                , userInfo.getEmail(), userInfo.getPhone(), userInfo.getType());
        mUser.setLogged(true);
        mUser.setLoginTime(System.currentTimeMillis());
        mUser.setLoginDomain(".");
        return userRepo.save(mUser);
    }

    @Override
    public MUser updateBasicInfo(UserInfo userInfo) {
        if (StringUtils.isEmpty(userInfo.getName())) {
            throw new IamException(ExceptionCode.USER_NOT_FOUND);
        }
        MUser user = userRepo.findByNameAndDeleted(userInfo.getName(), false);
        if (user == null) {
            throw new IamException(ExceptionCode.USER_NOT_FOUND);
        }
        if (!StringUtils.isEmpty(userInfo.getEmail())) {
            user.setEmail(userInfo.getEmail());
        }
        if (!StringUtils.isEmpty(userInfo.getPhone())) {
            user.setPhone(userInfo.getPhone());
        }
        return userRepo.save(user);
    }

    @Override
    public void logout(MUser user) {
        if (user == null) {
            return;
        }
        Optional<MUser> userOptional = userRepo.findById(user.getId());
        if (userOptional.isEmpty()) {
            return;
        }
        MUser mUser = userOptional.get();
        if (mUser.isLogged()) {
            mUser.setLogged(false);
            mUser.setLocked(false);
            userRepo.save(mUser);
        }
    }

    @Override
    public Page<MUser> queryUserList(UserPageRequest request) {
        Sort sort = Sort.unsorted();
        if (request.getSort() != null && !StringUtils.isEmpty(request.getSort().getDirection()) && request.getSort().getProps().length != 0){
            sort = Sort.by(Sort.Direction.valueOf(request.getSort().getDirection()), request.getSort().getProps());
        }
        Page<MUser> userPage = userDao.findByKeyword(request.getKeyword(), PageRequest.of(request.getNumber(), request.getSize(),
                sort));
        return userPage;
    }
}
