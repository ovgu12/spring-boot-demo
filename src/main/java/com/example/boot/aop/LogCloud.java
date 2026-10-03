package com.example.boot.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogCloud {

    @Before("execution(* com.example.boot.cloud..rest(..))")
    public void logBefore(JoinPoint jp) {
        log.info("Gonna do {} call", jp.getSignature().getName());
    }

}
