package com.wei.web;


import com.wei.web.entity.RegUser;
import com.wei.web.servie.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpSession;

@SpringBootTest
class UserServiceTests {
    // 自动注入，想要使用接口，就必须要给接口添加实现类
    // 而加上自动注入Autowired注解后，
    // Springboot会自动的帮我们去创建这个实现类
    @Autowired
    UserService service;

    @Test
    void reg() {
        RegUser user = new RegUser();
        user.setUsername("xm");
        user.setPassword("qwe");
        user.setNickname("小明");
        int count = service.reg(user);
        System.out.println("测试成功，返回值为：" + count);
    }

    @Test
    void login(){
        RegUser user = new RegUser();
        user.setUsername("xm");
        user.setPassword("qwe");
//        int count = service.login(user);
//        System.out.println("测试成功，返回值为：" + count);
    }



}
