package com.chinasoft.lgh.codeman.service.util;

import com.chinasoft.lgh.codeman.service.model.MUser;

public class TokenStore {
    public static ThreadLocal<MUser> currentUser = new ThreadLocal<>();

}
