package com.cn.annotations;

/**
 * @Author: zhangjixu
 * @CreateDate: 2018/10/17
 * @Description:
 * @Version: 1.0.0
 */

@BookAnnotation(bookName = "java 编程思想", briefOfBook = "java 学习指导书籍" )
public class Book {

    @BookAnnotation(bookName = "算法导论", briefOfBook = "算法学习书籍")
    public void getBookInfo(){

    }

}
