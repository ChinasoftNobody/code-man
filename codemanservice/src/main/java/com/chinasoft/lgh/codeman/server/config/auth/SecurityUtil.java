package com.chinasoft.lgh.codeman.server.config.auth;

import com.chinasoft.lgh.codeman.server.model.MUser;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {

    public static MUser current(){
        return (MUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
