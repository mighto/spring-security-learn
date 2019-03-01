package com.ss.ssdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author wangf
 * @description：
 * @create 2019/02/26
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public Date hello() {
        return new Date();
    }

    @RequestMapping("/hl")
    public String hl(String username, String password) {
        System.out.println(username);
        System.out.println(password);
        return (username + password);
    }


}
