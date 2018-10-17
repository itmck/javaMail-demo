package com.qf.manager.service.impl;

import com.qf.manager.dao.mapper.UserMapper;
import com.qf.manager.pojo.User;
import com.qf.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create by it_mck 2018/10/14 2:01
 *
 * @Description:
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    /**
     *
     * 注册
     * @param user
     * @return
     */
    @Override
    public int registUser(User user) {

        return userMapper.registUser(user);
    }

    /**
     * 激活
     * @param code
     * @return
     */
    @Override
    public int activeUser(String code) {
        return userMapper.activeUser(code);
    }

    @Override
    public User login(User user) {
        user.setState(1);
        return userMapper.login(user);
    }


    @Override
    public User getVerifyEmail(String email) {
        return userMapper.getVerifyEmail(email);
    }
}
