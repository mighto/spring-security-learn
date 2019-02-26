package com.ss.ssdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

/**
 * @author wangf
 * @description：
 * @create 2019/02/26
 */
@EnableWebSecurity
// public class WebSecurityConfig implements WebMvcConfigurer {
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**", "/index").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").failureForwardUrl("/login-error").defaultSuccessUrl("/hello").permitAll()
                .and()
                .logout().permitAll();
    }

    protected void configure1(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 对所有人开放
                .antMatchers("/resources/**", "/about").permitAll()
                // 对ROLE_ADMIN的角色开放
                .antMatchers("/admin/**").hasRole("ADMIN")
                // 对拥有 ROLE_ADMIN 和 ROLE_DBA 的角色开放
                .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
                // 任何尚未匹配的URL只需要对用户进行身份验证
                .anyRequest().authenticated();
    }

    protected void customLogout(HttpSecurity http) throws Exception {
        http.logout()
                .logoutUrl("/my/logout")
                .logoutSuccessUrl("/my/index")
                .logoutSuccessHandler(new SimpleUrlLogoutSuccessHandler())
                .invalidateHttpSession(true)
                .addLogoutHandler(new CookieClearingLogoutHandler())
                .deleteCookies("cookieNamesToClear");
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser(User.withDefaultPasswordEncoder().username("admin").password("123456").roles("USER"));
    }

}
