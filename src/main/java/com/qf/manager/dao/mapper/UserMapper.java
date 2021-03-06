package com.qf.manager.dao.mapper;

import com.qf.manager.common.BaseMapper;
import com.qf.manager.pojo.User;

public interface UserMapper extends BaseMapper<User,Long> {

    //注册
    int registUser(User user);

    //激活
    int activeUser(String code);

    User login(User user);

    //验证邮箱是否被注册
    User getVerifyEmail(String email);

    //验证用户名是否被占用
    User getVerifyUName(String uname);
}