package com.cn.annotations;

/**
 * @Author: zhangjixu
 * @CreateDate: 2018/10/17
 * @Description:
 * @Version: 1.0.0
 */


import java.lang.annotation.*;


@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BookAnnotation {
    // 书名
    String bookName();
    // 书的简介
    String briefOfBook();

}
