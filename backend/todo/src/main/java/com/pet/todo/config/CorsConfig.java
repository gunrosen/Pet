package com.pet.todo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Gun on 12/4/18.
 */
@Configuration
public class CorsConfig {

    @Bean
    public SimpleCorsFilter corsFilter() {
        return new SimpleCorsFilter();
    }

    public static class SimpleCorsFilter implements Filter {

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {

        }

        @Override
        public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
            HttpServletResponse httpResponse = (HttpServletResponse) res;
            HttpServletRequest httpRequest = ((HttpServletRequest) req);

            String origin = httpRequest.getHeader("Origin");
            httpResponse.setHeader("Access-Control-Allow-Origin", origin);
            httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
            httpResponse.setHeader("Access-Control-Max-Age", "3600");
            httpResponse.setHeader("Access-Control-Allow-Headers", "x-requested-with, accept, authorization, content-type");
            httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
            chain.doFilter(req, res);
        }

        @Override
        public void destroy() {

        }
    }
}
