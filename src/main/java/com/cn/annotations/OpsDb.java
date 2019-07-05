package com.cn.annotations;

import java.lang.annotation.*;

/**
 * @Author: zhangjixu
 * @CreateDate: 2018/7/11
 * @Description:
 * @Version: 1.0.0
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OpsDb {
    String value();
}
