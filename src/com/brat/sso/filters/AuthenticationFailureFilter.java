package com.brat.sso.filters;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

/** Class to handle the event of failure login */
@Component("authenticationFailureFilter")
public class AuthenticationFailureFilter
        extends SimpleUrlAuthenticationFailureHandler {

    private static final Logger log = Logger
            .getLogger(AuthenticationFailureFilter.class);

    /** Method implemented from the extended class this will handle the
     * unsuccessful login, will redirect to login page if login failed */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
            HttpServletResponse response, AuthenticationException exception)
            throws IOException, ServletException {

        log.info(
                "Login failed,redirecting user to login page with param error=true");
        log.info("Credentials for failed attempt was username : "
                + request.getParameter("email") + " password : "
                + request.getParameter("password"));
        super.onAuthenticationFailure(request, response, exception);
    }
}
