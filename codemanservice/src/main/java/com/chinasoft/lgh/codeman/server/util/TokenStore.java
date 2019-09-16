package com.chinasoft.lgh.codeman.server.util;

import com.chinasoft.lgh.codeman.server.model.MUser;
import org.springframework.security.core.context.SecurityContextHolder;

public class TokenStore {
    public static MUser currentUser() {
        return (MUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
