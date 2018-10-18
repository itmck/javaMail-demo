package com.qf.manager.service;

import com.qf.manager.pojo.User;

/**
 * Create by it_mck 2018/10/14 2:00
 *
 * @Description:
 * @Version: 1.0
 */
public interface UserService {

    int registUser(User user);

    int activeUser(String code);

    //登录
    User login(User user);

    //验证邮箱是否被注册
    User getVerifyEmail(String email);

    //验证用户名是否被占用
    User getVerifyUName(String uname);
}
