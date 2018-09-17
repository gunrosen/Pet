package com.pet.todo.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

/**
 * Created by Gun on 9/17/18.
 */
public class BeforeLoggingAdvice implements MethodBeforeAdvice {
    private static final Logger logger = Logger.getLogger(BeforeLoggingAdvice.class);
    @Override
    public void before(Method method, Object[] objects, @Nullable Object o) throws Throwable {
            logger.info("before method :"+ method.getName());
    }
}
