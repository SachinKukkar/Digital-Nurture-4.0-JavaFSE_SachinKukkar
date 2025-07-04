package com.library.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    @Before("execution(* com.library.service.BookService.*(..))")
    public void beforeMethod() {
        System.out.println("[LOG] ==> Before method execution");
    }

    @After("execution(* com.library.service.BookService.*(..))")
    public void afterMethod() {
        System.out.println("[LOG] ==> After method execution");
    }
}
