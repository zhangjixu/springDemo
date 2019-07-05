package com.cn.dao;

import com.cn.model.User;

import java.util.List;
import java.util.Map;

/**
 * @Author: zhangjixu
 * @CreateDate: 2018/10/20
 * @Description:
 * @Version: 1.0.0
 */
public interface UserDao {

    public List<User> queryAllUser();
    public User queryUserById(int id);
    public int addUser(User user);
    public void updateUser(User user);
    public void deleteUser(int id);
    public Map query(int id);

}
