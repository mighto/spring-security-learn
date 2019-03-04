package com.ss.ssdemo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author mistaker
 * @description：
 * @create 2019/02/27
 */
@Getter
@Setter
@ToString
public class User {

    private String id;
    private String username;
    private String password;
    private String nickname;
    private String roles;

}
