package com.cn.annotations.java;

import java.lang.annotation.*;

/**
 * @Author: zhangjixu
 * @CreateDate: 2018/10/19
 * @Description:
 * @Version: 1.0.0
 */

@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Table {
    String table() default "test";
    String column() default "column";
    String type() default "int";
}
