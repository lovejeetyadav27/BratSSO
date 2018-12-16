package com.brat.sso.utils;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.brat.sso.constant.KeyConstant;
import com.brat.sso.model.JwtUser;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {
    public static String generateToken(String signingKey, JwtUser jwtUser) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        JwtBuilder builder = Jwts.builder()
                .setSubject(jwtUser.getUserName())
                .setIssuedAt(now)
                .claim("jwt_user",jwtUser)
                .signWith(SignatureAlgorithm.HS256, signingKey);

        return builder.compact();
    }

    public static String getJwtToken(HttpServletRequest httpServletRequest, String jwtTokenCookieName, String signingKey){
        String token = CookieUtil.getValue(httpServletRequest, jwtTokenCookieName);
        return token;
    }

    public static JwtUser getJwtUser(String token){
        return (JwtUser) Jwts.parser().setSigningKey(KeyConstant.signingKey).parseClaimsJws(token).getBody().get("jwt_user");
    }
}