package com.auth_server.auth_server.com.utils;

import com.auth_server.auth_server.com.constant.KeyConstant;
import com.auth_server.auth_server.com.model.JwtUser;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

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