package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/admin")

public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping("/tologin")
    public String tologin(){

        return "login";

    }


    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response){

        response.addHeader("auth","123");
        String username = request.getParameter("username");

        String password = request.getParameter("password");

        System.out.println(username+":"+password);

        return "redirect:index";

    }

    /**
     * 在 @PreAuthorize 中我们可以利用内建的 SPEL 表达式：比如 'hasRole()' 来决定哪些用户有权访问。
     * 需注意的一点是 hasRole 表达式认为每个角色名字前都有一个前缀 'ROLE_'。所以这里的 'ADMIN' 其实在
     * 数据库中存储的是 'ROLE_ADMIN' 。这个 @PreAuthorize 可以修饰Controller也可修饰Controller中的方法。
     **/
    @PreAuthorize("hasRole('admin')")
    @RequestMapping("/index")
    public String index(HttpServletRequest request){
        System.out.println(request.getHeader("auth"));

        System.out.println(userService.getByUsername("liang").toString());
        return "index";
    }
}
