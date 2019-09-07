package com.chinasoft.lgh.codeman.server.service;

import com.chinasoft.lgh.codeman.server.model.MUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        MUser mUser = userService.queryByUsername(s);
        if (mUser == null){
            throw new UsernameNotFoundException("user not exists");
        }
        return mUser;
    }
}
