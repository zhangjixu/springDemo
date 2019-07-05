package com.cn.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @Author: zhangjixu
 * @CreateDate: 2018/10/17
 * @Description:
 * @Version: 1.0.0
 */
public class ParseAnnotation {

    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = Class.forName("com.cn.annotations.Book");
        // 解析类的注解
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            BookAnnotation bookAnnotation = (BookAnnotation) annotation;
            System.out.println(" class bookName :  " + bookAnnotation.bookName() + " briefOfBook : " + bookAnnotation.briefOfBook());
        }

        // 解析方法的注解
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            boolean hasAnnotation = method.isAnnotationPresent(BookAnnotation.class);
            if (hasAnnotation) {
                BookAnnotation bookAnnotation = (BookAnnotation) method.getAnnotation(BookAnnotation.class);
                System.out.println(" method bookName :  " + bookAnnotation.bookName() + " briefOfBook : " + bookAnnotation.briefOfBook());
            }
        }

    }

}
