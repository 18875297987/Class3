package com.wei.study03.controller;

import com.wei.study03.pojo.dto.UserDTO;
import com.wei.study03.pojo.entity.User;
import com.wei.study03.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
* @RequestMapping:可以匹配所有HTTP方法（get、post、put等），支持路径、方法、参数配置，需要手动指定方法类型
* @GetMapping：只能接收get方法请求
* @PostMapping：只能接受post方法请求
* 什么情况下使用GetMapping和PostMapping呢？
* 现在就简单理解成：去看方法的参数列表，若是有@RequestBody注解，那么就使用PostMapping
* 若是没有@RequestBody注解，那么就使用GetMapping
* */

/*
* POJO的常见用途
* 数据传输对象(DTO):用于前端向后端发送数据，后端用来接收前端数据的类
* 实体类(Entity)：对应数据库表
* 视图对象(VO):后端韩慧给前端的数据对象
* */

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService service;

    @PostMapping("/reg")
    public int reg(@RequestBody UserDTO userDTO){
        // 处理数据
        int result = service.insertUser(userDTO);
        return result;
    }
}
