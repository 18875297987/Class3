package com.wei.web.servie.impl;

import com.wei.web.entity.RegUser;
import com.wei.web.mapper.UserMapper;
import com.wei.web.servie.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public int reg(RegUser user) {
        RegUser dataUser = userMapper.selectByUserName(user.getUsername());

        if (dataUser != null){
            return 0;
        }

        userMapper.insert(user);

        return 1;
    }

    @Override
    public int login(RegUser user) {
        RegUser dataUser = userMapper.selectByUserName(user.getUsername());
        if (dataUser == null){
            return 0;
        }

        if (dataUser.getPassword().equals(user.getPassword())){
            return 1;
        }

        return 2;
    }

    @Override
    public String getNickname(RegUser user) {
        RegUser dataUser = userMapper.selectByUserName(user.getUsername());
        return dataUser.getNickname();
    }

    @Override
    public RegUser getUser(String username) {
        RegUser dataUser = userMapper.selectByUserName(username);
        return dataUser;
    }

    @Override
    public int change(RegUser user) {
        int count = userMapper.change(user);
        return count;
    }


}
