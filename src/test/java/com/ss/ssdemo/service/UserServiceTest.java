package com.ss.ssdemo.service;

import com.ss.ssdemo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wangf
 * @description：
 * @create 2019/02/27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService service;

    @Test
    public void a() {
        User user = service.getByUsername("admin");
        assert user != null;
    }

}
