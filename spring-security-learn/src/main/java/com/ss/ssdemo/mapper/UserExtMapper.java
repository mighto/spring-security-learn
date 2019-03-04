package com.ss.ssdemo.mapper;

import com.ss.ssdemo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author mistaker
 * @description：
 * @create 2019/02/27
 */
public interface UserExtMapper {

    @Insert("INSERT INTO S_USER(username, password, nickname, roles) values (#{username}, #{password}, #{nickname}, #{roles})")
    int insert(User user);


    @Select("SELECT * FROM S_USER WHERE username = #{username}")
    List<User> queryByUsername(@Param("username") String username);

}
