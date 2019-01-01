package com.brat.sso.filters;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

//@Component("customLoginUrlAuthenticationEntryPoint")
public class CustomLoginUrlAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint{

	public CustomLoginUrlAuthenticationEntryPoint(String loginFormUrl) {
		super(loginFormUrl);
	}
	
	/**
	 * Performs the redirect (or forward) to the login form URL.
	 */
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		String prevUrl = request.getServletPath()+(request.getQueryString()!=null ? "?"+request.getQueryString() : "");
		if(prevUrl!=null && !prevUrl.isEmpty() && !prevUrl.equals("/"))
			request.getSession().setAttribute("lastUrl",prevUrl);
		super.commence(request, response, authException);
	}

}
