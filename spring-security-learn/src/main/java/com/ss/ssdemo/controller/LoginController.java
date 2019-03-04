package com.ss.ssdemo.controller;

import com.ss.ssdemo.entity.User;
import com.ss.ssdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wangf
 * @description：
 * @create 2019/02/26
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping({"/", "/index", "/home"})
    public String root() {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(User user) {
        if (userService.insert(user)) {
            return "redirect:register?success";
        }
        return "redirect:register?error";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @RequestMapping("/fetch")
    public String fetch() {
        return "fetch";
    }

}
