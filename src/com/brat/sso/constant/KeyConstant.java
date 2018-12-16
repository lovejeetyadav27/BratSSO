package com.brat.sso.constant;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.brat.sso.model.DBUser;

public class KeyConstant {
    public static final String jwtTokenCookieName = "JWT-TOKEN";
    public static final String signingKey = "signingKey";
    public static final Map<String, DBUser> credentials = new HashMap<>();
    static {

        credentials.put("jitendra@123", new DBUser("jitendra kumar","jitendra@123","jitendra@123", Arrays.asList("ADMIN","USER")));
        credentials.put("user@123", new DBUser("User ","user@123","user@123", Arrays.asList("USER")));
    }
}
