package com.hatcher.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author: HatcherCheung
 * Date:  2021/10/7
 */
@Component
@Aspect
public class ServiceLogAspect {
    private static final Logger logger = LoggerFactory.getLogger(ServiceLogAspect.class);
    private static final Integer TIMEOUT_ERROR_VALUE = 3000;
    private static final Integer TIMEOUT_WARN_VALUE = 2000;

    /**
     * 切面表达式execution
     * 1. * 代表方法的返回值，'*'代表所有返回值类型
     * 2. com.hatcher.service 要监控的包名
     * 3. .. 当前包以及子包
     * 4. * 包下的所有类
     * 5. .*(..) 类的所有方法
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("execution(* com.hatcher.service..*.*(..))")
    public Object recordTimeLog(ProceedingJoinPoint joinPoint) throws Throwable {
        // 打印正在执行某个service的某个方法
        logger.info("===== 开始执行 {}.{} =====",
                joinPoint.getTarget().getClass(),
                joinPoint.getSignature().getName()
        );
        // 记录开始时间
        long beginTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        // 记录结束时间
        long endTime = System.currentTimeMillis();
        long takeTime = endTime - beginTime;
        if (takeTime > TIMEOUT_ERROR_VALUE) {
            logger.error("======执行结束，耗时：{} 毫秒======", takeTime);
        } else if (takeTime > TIMEOUT_WARN_VALUE) {
            logger.warn("======执行结束，耗时：{} 毫秒======", takeTime);
        } else {
            logger.info("======执行结束，耗时：{} 毫秒======", takeTime);
        }
        return result;
    }
}
