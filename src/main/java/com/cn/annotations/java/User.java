package com.cn.annotations.java;

/**
 * @Author: zhangjixu
 * @CreateDate: 2018/10/19
 * @Description:
 * @Version: 1.0.0
 */
@Table(table = "user")
public class User {

    @Table(column = "name", type = "String")
    private String name;
    @Table(column = "age", type = "int")
    private int age;

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
