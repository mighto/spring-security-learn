package com.ss.ssdemo.service;

import com.ss.ssdemo.entity.User;

/**
 * @author mistaker
 * @description：
 * @create 2019/02/27
 */
public interface UserService {

    /**
     * 添加新用户
     *
     * username 唯一， 默认 USER 权限
     */
    boolean insert(User user);

    /**
     * 查询用户信息
     * @param username 账号
     * @return User
     */
    User getByUsername(String username);

}
