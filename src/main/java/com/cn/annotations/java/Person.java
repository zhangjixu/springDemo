package com.cn.annotations.java;

import com.cn.annotations.java.Table;

import java.util.Date;

/**
 * @Author: zhangjixu
 * @CreateDate: 2018/10/19
 * @Description:
 * @Version: 1.0.0
 */
@Table(table = "test")
public class Person {
    @Table(column = "name", type = "String")
    private String name;
    @Table(column = "age", type = "int")
    private int age;
    @Table(column = "cdate", type = "String")
    private String cdate;

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
