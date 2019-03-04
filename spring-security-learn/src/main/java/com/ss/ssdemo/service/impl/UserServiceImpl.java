package com.ss.ssdemo.service.impl;

import com.ss.ssdemo.constant.RoleConstants;
import com.ss.ssdemo.entity.User;
import com.ss.ssdemo.mapper.UserExtMapper;
import com.ss.ssdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mistaker
 * @description：
 * @create 2019/02/27
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserExtMapper userExtMapper;

    @Override
    public boolean insert(User user) {
        String username = user.getUsername();
        if (exist(username)) {
            return false;
        }
        user.setRoles(RoleConstants.ROLE_USER);
        encryptPassword(user);
        int result = userExtMapper.insert(user);
        return result == 1;
    }

    @Override
    public User getByUsername(String username) {
        List<User> list = userExtMapper.queryByUsername(username);
        if (!list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 判断用户名是否重复
     *
     * @param username
     * @return
     */
    private boolean exist(String username) {
        User user = getByUsername(username);
        return (user != null);
    }

    /**
     * 密码加密
     *
     * @param user
     */
    private void encryptPassword(User user) {
        String password = user.getPassword();
        password = new BCryptPasswordEncoder().encode(password);
        user.setPassword(password);
    }

}
