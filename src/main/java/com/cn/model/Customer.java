package com.cn.model;

import java.util.List;

/**
 * @Author: zhangjixu
 * @CreateDate: 2018/10/22
 * @Description:
 * @Version: 1.0.0
 */
public class Customer {

    private Integer userId;
    private String userName;
    private Integer age;
    private List<MobilePhone> mobilePhone;//土豪,多个手机,1对多

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<MobilePhone> getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(List<MobilePhone> mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", mobilePhone=" + mobilePhone +
                '}';
    }
}
