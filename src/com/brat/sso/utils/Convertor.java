package com.brat.sso.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Optional;


@Component
public class Convertor extends ObjectMapper{



    @Override
    public <T> T convertValue(Object fromValue, Class<T> toValueType) throws IllegalArgumentException {

        return super.convertValue(fromValue, toValueType);
    }

    public  AuthenticateRequest convertValue(HttpServletRequest httpServletRequest)
    {

        AuthenticateRequest authenticateRequest = new AuthenticateRequest();
        if(httpServletRequest.getParameter("username")==null ||
                httpServletRequest.getParameter("password")==null || httpServletRequest.getParameter("redirectUrl")==null){
            System.out.println( "username"+httpServletRequest.getParameter("username")+"request is null");
             throw new CustomAuthenticationException("invalid request");
        }
        authenticateRequest.setUsername(httpServletRequest.getParameter("username"));
        authenticateRequest.setPassword(httpServletRequest.getParameter("password"));
        authenticateRequest.setRedirectUrl(httpServletRequest.getParameter("redirectUrl"));
        return authenticateRequest;

    }

     public Optional<String> streamToString(InputStream inputStream) throws IOException{
         StringBuilder stringBuilder = new StringBuilder();
         String line = null;

         try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
             while ((line = bufferedReader.readLine()) != null) {
                 stringBuilder.append(line);
             }
         }

         return Optional.ofNullable(stringBuilder.toString());
     }
}


