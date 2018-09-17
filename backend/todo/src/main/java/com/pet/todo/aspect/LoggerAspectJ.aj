package com.pet.todo.aspect;

import com.sun.javafx.tools.packager.Log;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by Gun on 9/17/18.
 */
@Aspect
@Component
public class LoggerAspectJ {
    private static final Logger logger = Logger.getLogger(LoggerAspectJ.class);

    @Before("execution(* com.pet.todo.service.EmployeeService*.*(..))")
    public void logBefore(JoinPoint joinPoint){
        logger.info("Log before EmployeeService:"+joinPoint.getSignature().getName());
    }
}
