package com.jy.study.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
public class TimeTraceAop {

    //
    //@Around("execution(* com.jy.study..*(..))) // Bean으로 수동 등록시 본인을 등록할때 순환참조 에러가 나기때문에 아래로 바꿈.
    @Around("execution(* com.jy.study..*(..)) && !target(com.jy.study.config.AppConfig)") //어디다 적용할건지? : 모든 패키지에 적용하기
    public Object execute(ProceedingJoinPoint joinPoint) throws  Throwable {
        long start = System.currentTimeMillis();
        System.out.println("start:: " + joinPoint.toString());
        try{

            return joinPoint.proceed();
        }
        finally {

            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END:: " + joinPoint.toString() + " " + timeMs + "ms");

        }
    }

}
