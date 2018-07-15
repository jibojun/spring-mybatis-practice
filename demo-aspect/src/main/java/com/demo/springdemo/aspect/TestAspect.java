package com.demo.springdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestAspect {

    @Pointcut("execution(* com.demo.springdemo.aspect..*.*(..))")
    public void pointCut(){}

    @Around("pointCut()")
    public void recordExecutionTime(ProceedingJoinPoint jp){
        long start=System.currentTimeMillis();
        try {
            jp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            long end=System.currentTimeMillis();
            System.out.println("Method:"+jp.getSignature().getName()+"'s execution time is "+(end-start)+"ms");
        }
    }
}
