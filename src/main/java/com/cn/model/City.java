package com.cn.model;

/**
 * @Author: zhangjixu
 * @CreateDate: 2018/10/23
 * @Description:
 * @Version: 1.0.0
 */
public class City {

    private int cityId;
    private String cityName;
    private Person person;

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", person=" + person +
                '}';
    }
}
