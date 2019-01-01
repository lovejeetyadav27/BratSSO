package com.brat.sso.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;


/** @author Sajid */
public class MVCRequestInterceptors implements HandlerInterceptor {

    private static final Logger log = Logger.getLogger(MVCRequestInterceptors.class);

   Boolean maintenance = false;


    /** CDN value specifies from where the static contents will be deliverd */
    @Value("${app.cdn}")
    private String cdn;

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {

    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {

    }

    /** Checking for maintainance bit and path for cdn<br>
     * If maintenance bit found to be 1 it will shown the maintenace page */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {

        log.debug("MVC request interceptor triggered to prehandle the request "+ request.getRequestURI());

        String contextPath = request.getContextPath();
        if ((cdn == null) || cdn.isEmpty()) {
            cdn = contextPath;
        }
        request.setAttribute("cdn", cdn);
        request.setAttribute("contextPath", contextPath);
        
        if (!maintenance) {
            return true;
        } else {

            log.info("Application is found under maintenance, the maintenace bit is not turned off (i.e it's not 0) ");

            /** show the maintenance page **/
            ModelAndView mav = new ModelAndView("maintenance");
            throw new ModelAndViewDefiningException(mav);
        }

    }


}
