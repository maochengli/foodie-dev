package com.maochengli.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 使用AOP记录service层所有方法执行时间
 */

@Aspect
@Component
public class ServiceLogAspect {

    static final Logger log = LoggerFactory.getLogger(ServiceLogAspect.class);

    /**
     * Spring 中AOP的五种通知
     *  1.前置通知  方法执行前置执行
     *  2.后置通知  方法正常执行之后执行
     *  3.环绕通知  方法执行前后执行
     *  4.异常通知  发生异常后执行
     *  5.最终通知  相当于finally
     */

    /**
     *
     * @param joinPoint 切入点
     * execution 表达式
     *   第一处 *                                  代表所有返回值
     *   第二处 com.maochengli.service.impl        AOP监控的类的包路径
     *   第三处 ..                                 该包及所有子包的下的所有类
     *   第四处 *                                  代表所有类
     *   第五处 *(..)                              *代表方法名  (..)代表所有参数
     * @return
     *
     *
     */
    @Around("execution(* com.maochengli.service.impl..*.*(..))")
    public Object recordTimeLog(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("-------------------开始执行{}.{}----------------",            // {}为占位符
                joinPoint.getTarget().getClass()                                // 类名
                ,joinPoint.getSignature().getName());                           // 方法名

        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long end = System.currentTimeMillis();

        long takeTime = end - start;

        if(takeTime > 3000){
            log.error("-----执行结束，耗时{}毫秒----", takeTime);
        } else if(takeTime > 2000){
            log.warn("-----执行结束，耗时{}毫秒----", takeTime);
        }else {
            log.info("-----执行结束，耗时{}毫秒----", takeTime);
        }


        return proceed;

    }



}
