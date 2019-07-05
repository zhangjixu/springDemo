package com.cn.dao;

import com.cn.model.Customer;

/**
 * @Author: zhangjixu
 * @CreateDate: 2018/10/22
 * @Description:
 * @Version: 1.0.0
 */
public interface CustomerDao {
    Customer getCustomer(int id);
}
