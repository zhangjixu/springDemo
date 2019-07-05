package com.cn.serviceImpl;

import com.cn.annotations.OpsDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @Author: zhangjixu
 * @CreateDate: 2018/10/15
 * @Description:
 * @Version: 1.0.0
 */
@Service
public class MysqlOpsImpl {

    @Autowired
    private JdbcTemplate mysqlJdbcTemplate;

    @OpsDb("insert int `test`(`name`, `age`) values('张三', 19);")
    public void test() {

    }

    public void sss() {

    }



}
