package com.cn.model;

/**
 * @Author: zhangjixu
 * @CreateDate: 2018/10/22
 * @Description:
 * @Version: 1.0.0
 */
public class MobilePhone {
    private Integer mobilePhoneId;
    private String brand;//品牌
    private String price;//价格
    private Integer customerId;

    public Integer getMobilePhoneId() {
        return mobilePhoneId;
    }

    public void setMobilePhoneId(Integer mobilePhoneId) {
        this.mobilePhoneId = mobilePhoneId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "MobilePhone{" +
                "mobilePhoneId=" + mobilePhoneId +
                ", brand='" + brand + '\'' +
                ", price='" + price + '\'' +
                ", customerId=" + customerId +
                '}';
    }
}
