package com.chinasoft.lgh.codeman.server.util;

import com.chinasoft.lgh.codeman.server.model.MUser;

public class TokenStore {
    public static ThreadLocal<MUser> currentUser = new ThreadLocal<>();

}
