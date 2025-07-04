package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Around("execution(* com.library.service.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed(); // execute target method

        long end = System.currentTimeMillis();
        String methodName = joinPoint.getSignature().toShortString();
        System.out.println("⏱️ " + methodName + " executed in " + (end - start) + " ms");

        return result;
    }
}
