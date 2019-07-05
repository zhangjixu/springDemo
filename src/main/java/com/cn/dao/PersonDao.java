package com.cn.dao;

import com.cn.model.City;
import com.cn.model.Person;

/**
 * @Author: zhangjixu
 * @CreateDate: 2018/10/22
 * @Description:
 * @Version: 1.0.0
 */
public interface PersonDao {

    Person getPerson(int id);
    City getCity(int id);

}
