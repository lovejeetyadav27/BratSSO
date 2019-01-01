package com.brat.sso.filters;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/** Class to handle the event when login is success */
@Component("authenticationSuccessFilter")
public class AuthenticationSuccessFilter
        extends SimpleUrlAuthenticationSuccessHandler {

    private static final Logger log = Logger
            .getLogger(AuthenticationSuccessFilter.class);

    //@Autowired private ServiceLdap serviceLdap;

    /** Method implemented from the super class.<br>
     * On successful login it will redirect user to home page <br>
     * This method can be tweaked to provide different views based on the roles
     * after successful login */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
            HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {

    	// AuthenticUser authUser = (AuthenticUser) authentication.getPrincipal();
        // log.debug(authUser.getEmpId()+" has logged in successfully");
         //serviceLdap.saveOrUpdateUserToDB(authUser);
         
        String prevUrl = request.getSession().getAttribute("lastUrl")==null ? "" :  (String)request.getSession().getAttribute("lastUrl");
        if(prevUrl!=null && !prevUrl.isEmpty()){
        	log.info(prevUrl);
        	setDefaultTargetUrl(prevUrl);
        	 request.getSession().removeAttribute("lastUrl");
        }else{
        	
             setDefaultTargetUrl("/");
        }
        
        super.onAuthenticationSuccess(request, response, authentication);
    }

}
