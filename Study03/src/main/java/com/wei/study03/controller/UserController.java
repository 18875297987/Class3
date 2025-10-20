package com.wei.study03.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.wei.study03.pojo.dto.UserChangeDTO;
import com.wei.study03.pojo.dto.UserDTO;
import com.wei.study03.pojo.entity.User;
import com.wei.study03.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;

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

    /*@ApiOperation(别名)：可以给方法起一个中文名或者是别名
    * @ApiOperationSupport(order = 100):可以让方法名进行排序，值越小越靠前
    * */
    @PostMapping("/reg")
    @ApiOperation("01.注册功能")
    @ApiOperationSupport(order = 100)
    public int reg(@RequestBody UserDTO userDTO){
        // 处理数据
        int result = service.insertUser(userDTO);
        return result;
    }

    @PostMapping("/login")
    @ApiOperation("02.登录功能")
    @ApiOperationSupport(order = 200)
    /*@ApiIgnore:可以让前端不提交后面对象的值，也就是可以忽略掉后面的对象*/
    public int login(@RequestBody UserDTO userDTO, @ApiIgnore HttpSession session){
        // 处理数据
        int result = service.chackUser(userDTO);
        if (result == 605){
            // 向session中存入登录状态，存入用户名
            session.setAttribute("username", userDTO.getUsername());
        }
        return result;
    }

    @PostMapping("/changeUserInfo")
    @ApiOperation("03.修改用户信息")
    @ApiOperationSupport(order = 300)
    public int changeUserInfo(@RequestBody UserChangeDTO userChangeDTO){
        // 处理数据
        int result = service.changeUserInfo(userChangeDTO);
        return result;
    }

    @GetMapping("/getUserInfo")
    @ApiOperation("04.获取用户")
    @ApiOperationSupport(order = 400)
    public User getUserInfo(String username){
        return service.selectByUsername(username);
    }

}
