package com.pet.todo.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * Created by Gun on 9/17/18.
 */
@Aspect
@Component
public class LoggerAspectJ {
    private static final Logger logger = Logger.getLogger(LoggerAspectJ.class);

    @Pointcut(value = "execution(* com.pet.todo.service.impl.EmployeeServiceImpl.*(..))")
    public void serviceTask(){

    }

    @Pointcut("within(@org.springframework.stereotype.Controller *)")
    public void controller() {
    }

    @Pointcut("execution(* *.*(..))")
    protected void allMethod() {
    }

    @Pointcut("execution(public * *(..))")
    protected void loggingPublicOperation() {
    }

    @Pointcut("execution(* *.*(..))")
    protected void loggingAllOperation() {
    }

    @Pointcut("within(org.learn.log..*)")
    private void logAnyFunctionWithinResource() {
    }

    @Before("serviceTask()")
    public void beforeServiceTask(){
        System.out.print("Before service sysout");
        logger.info("BEFORE serviceTask");
    }

    @Before("controller()")
    public void beforeControllerTask(){
        System.out.print("Before Controller stout");
        logger.info("BEFORE controller");
    }


    @Before("controller() && allMethod() && args(..,request)")
    public void logBefore(JoinPoint joinPoint, HttpServletRequest request) {

        logger.debug("Entering in Method :  " + joinPoint.getSignature().getName());
        logger.debug("Class Name :  " + joinPoint.getSignature().getDeclaringTypeName());
        logger.debug("Arguments :  " + Arrays.toString(joinPoint.getArgs()));
        logger.debug("Target class : " + joinPoint.getTarget().getClass().getName());

        if (null != request) {
            logger.debug("Start Header Section of request ");
            logger.debug("Method Type : " + request.getMethod());
            Enumeration headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String headerName = (String) headerNames.nextElement();
                String headerValue = request.getHeader(headerName);
                logger.debug("Header Name: " + headerName + " Header Value : " + headerValue);
            }
            logger.debug("Request Path info :" + request.getServletPath());
            logger.debug("End Header Section of request ");
        }
    }

    //Around -> Any method within resource annotated with @Controller annotation
    @Around("controller() && allMethod()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();
        try {
            String className = joinPoint.getSignature().getDeclaringTypeName();
            String methodName = joinPoint.getSignature().getName();
            Object result = joinPoint.proceed();
            long elapsedTime = System.currentTimeMillis() - start;
            logger.debug("Method " + className + "." + methodName + " ()" + " execution time : "
                    + elapsedTime + " ms");

            return result;
        } catch (IllegalArgumentException e) {
            logger.error("Illegal argument " + Arrays.toString(joinPoint.getArgs()) + " in "
                    + joinPoint.getSignature().getName() + "()");
            throw e;
        }
    }

}
