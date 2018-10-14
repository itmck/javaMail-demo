package com.qf.manager.dao.mapper;

import com.qf.manager.pojo.User;

public interface UserMapper {

    int insert(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //注册
    int registUser(User user);

    //激活
    int activeUser(String code);

    User login(User user);
}