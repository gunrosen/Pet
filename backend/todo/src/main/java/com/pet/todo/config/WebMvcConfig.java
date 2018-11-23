package com.pet.todo.config;

import com.pet.todo.interceptor.LogInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by Gun on 11/21/18.
 */
@Configuration
@ComponentScan(basePackages = {"com.pet.todo.interceptor"})
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    LogInterceptor logInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInterceptor);
    }
}
