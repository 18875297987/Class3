package com.wei.web.controller;

import com.wei.web.entity.RegUser;
import com.wei.web.entity.UserMapper2;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class UserController {
    ArrayList<RegUser> arr = new UserMapper2().getUserArr();

    @RequestMapping("/user/reg")
    public int reg(@RequestBody RegUser user){


        for (RegUser u : arr){
            if (u.getUsername().equals(user.getUsername())){
                return 0;
            }
        }
        arr.add(user);
        for (RegUser u : arr){
            System.out.println(u);
        }
        return 1;
    }

    @RequestMapping("/user/login")
    public int login(@RequestBody RegUser user){
        for (RegUser u : arr){
            if (u.getUsername().equals(user.getUsername())){
                if (u.getPassword().equals(user.getPassword())){
                    return 1;
                }
                return 2;
            }
        }
        return 0;

    }


}
