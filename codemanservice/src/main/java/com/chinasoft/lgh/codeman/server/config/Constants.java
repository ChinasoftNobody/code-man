package com.chinasoft.lgh.codeman.server.config;

import java.nio.charset.Charset;

public class Constants {
    public static final String IAM_TOKEN_HEADER = "IAM-TOKEN";
    public static final String REGISTER = "register";
    public static final String PUBLIC = "/public";

    public static final Charset CHARSET = Charset.forName("UTF-8");

    private Constants() {
    }

    public static final int ONE_DAY_MILLISECONDS = 1000 * 60 * 60 * 24;
}
