package com.movie.aop.advice;

import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MethodHeaderAdvice {

    //Write implementation for Aspect that is called advice
    @Before("execution(* com.movie.dao.*.*(..))")
    public void logStatement(JoinPoint joinPoint) {
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            System.out.println("Method "+ joinPoint.getSignature().getName()+" is called at "+new Date());
            System.out.println("Method input is  "+ Arrays.asList(joinPoint.getArgs()));
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    }

}
