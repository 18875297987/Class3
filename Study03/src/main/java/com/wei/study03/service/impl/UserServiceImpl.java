package com.wei.study03.service.impl;

import com.wei.study03.pojo.dto.UserDTO;
import com.wei.study03.pojo.entity.User;
import com.wei.study03.mapper.UserMapper;
import com.wei.study03.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper mapper;

    // 用户注册业务方法
    @Override
    public int insertUser(UserDTO userDTO) {
        // 1.能不能注册（检查用户名是否已经存在于数据库中）
        User result = mapper.selectByUsername(userDTO.getUsername());
        // 如果result的值不为null，说明用户名已被使用，反之，用户名就没有使用过
        if (result != null){
            return 601; // 表示用户名已被注册
        }
        // 创建User对象，准备向数据库中添加数据
        User user = new User();
        // 调用BeanUtils.copyProperties(源类, 将源类的数据复制的目标类); 将参数对象中的属性复制到user对象中
        // 注意：在复制的时候，会将两个类中同样成员变量名的属性进行复制
        BeanUtils.copyProperties(userDTO, user);
        // 2.如果不存在，开始执行注册流程：加密密码，补全数据，插入到数据库
        // 生成salt盐值，一般盐值使用的是UUID，UUID是随机生成的
        String salt = UUID.randomUUID().toString();
        System.out.println(salt);
        // 取出密码
        String password = user.getPassword();
        // 加密密码
        String md5Password = getMd5(salt,password);
        // 将加密的密码设为新密码,提高安全性
        user.setPassword(md5Password);
        // 补全数据
        user.setSalt(salt);
        user.setIs_delete(0); // 0-未注销 1-已注销 2-封禁
        user.setCreated_user(user.getUsername());
        user.setCreated_time(new Date());
        user.setModified_user(user.getModified_user());
        user.setModified_time(new Date());
        // 3.将数据插入到数据库
        int rows = mapper.insert(user);
        if (rows != 1){
            return 603; // 数据库异常
        }
        return 602; // 注册成功
    }

    public String getMd5(String salt, String password){
        for (int i = 0; i < 3; i++) {
            // 调用md5加密算法将密码和盐值拼接在一起后进行加密
            password = DigestUtils.md5DigestAsHex((salt + password).getBytes());
        }
        return password;
    }


}
