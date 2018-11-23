package com.pet.todo.interceptor;

import org.apache.log4j.Logger;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Enumeration;

/**
 * Created by Gun on 11/21/18.
 */
@Component
public class LogInterceptor implements HandlerInterceptor {

    private static final Logger logger = Logger.getLogger(LogInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
            logger.info("Headers of Request: " + headers.nextElement());
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        Collection<String> headers = response.getHeaderNames();

        logger.info("Headers of Response: " + headers);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }
}
