package com.cn.annotations;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


/**
 * @Author: zhangjixu
 * @CreateDate: 2018/7/11
 * @Description:
 * @Version: 1.0.0
 */
@Aspect
@Component
public class OpsDbProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger("time");
    @Autowired
    private JdbcTemplate mysqlJdbcTemplate;

    // 定义切点作用范围
    @Pointcut("execution(* com.cn.serviceImpl..*.*(..))")
    public void myMethod() {
    }

    // 切点范围内并且有 CountTime 注解的方法可以用此环绕通知
    @Around("myMethod() && @annotation(OpsDb)")
    public Object countTime(ProceedingJoinPoint pjp) throws Exception {
        // 获取此方法所属类的 class name
        String targetName = pjp.getTarget().getClass().getName();
        // 获取此方法的名称
        String methodName = pjp.getSignature().getName();
        // 获取调用此方法的实际参数
        Object[] args = pjp.getArgs();
        Object obj = null;

        // 获取此方法上的 OpsDb 注解实例
        OpsDb opsDb = ((MethodSignature) pjp.getSignature()).getMethod().getAnnotation(OpsDb.class);
        String sql = opsDb.value();
        mysqlJdbcTemplate.update(sql);

        System.out.println(" ----------------- opsDb success");

        try {
            // 执行目标方法
            obj = pjp.proceed(args);
        } catch (Throwable throwable) {
            LOGGER.error("统计 {}.{} 方法执行耗时环绕通知出错 {}", targetName, methodName, throwable.getMessage());
        }
        return obj;
    }


}
