package com.wei.web.controller;

import com.wei.web.entity.RegUser;
import com.wei.web.servie.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class UserController {
//    ArrayList<RegUser> arr = new UserMapper2().getUserArr();
//    String nickname;

    @Autowired
    UserService userService;

    @RequestMapping("/reg")
    public int reg(@RequestBody RegUser user){
//        for (RegUser u : arr){
//            if (u.getUsername().equals(user.getUsername())){
//                return 0;
//            }
//        }
//        arr.add(user);
//        for (RegUser u : arr){
//            System.out.println(u);
//        }
//        return 1;

        int result = userService.reg(user);
        System.out.println("添加成功，返回值：" + result);
        return result;

    }

    /*
    * Session（会话）是服务器为识别并记录单个用户的访问状态而创建的“临时档案”，可以让服务器记住用户（比如是否登录、购物车内容）
    * */
    @RequestMapping("/login")
    public int login(@RequestBody RegUser user , HttpSession session){
//        for (RegUser u : arr){
//            if (u.getUsername().equals(user.getUsername())){
//                if (u.getPassword().equals(user.getPassword())){
//                    nickname = u.getNickname();
//                    return 1;
//                }
//                return 2;
//            }
//        }
//        return 0;
        int result = userService.login(user);
        if (result == 1){
            // 向seesion中存入登录状态，存入用户名
            // session.setAttribute("存入数据的名称",数据内容);
            session.setAttribute("loginUser",user);
        }
        return result;
    }

    @RequestMapping("/geuNickname")
    public String getNickname(HttpSession session){
//        return nickname;
        RegUser user = (RegUser)session.getAttribute("loginUser");
        String nickname = "";

        try {
            nickname = userService.getNickname(user);
        }catch (NullPointerException n){
            System.out.println("用户还未登录！");
        }

        return nickname;
    }

    @RequestMapping("/getUser")
    public RegUser getUser(HttpSession session){
        RegUser loginUser = (RegUser) session.getAttribute("loginUser");
        RegUser user = userService.getUser(loginUser.getUsername());
        return user;
    }

    @RequestMapping("/change")
    public int change(@RequestBody RegUser user){
        int result = userService.change(user);
        return result;
    }



}
