package com.wei.study03;

import com.wei.study03.pojo.dto.UserDTO;
import com.wei.study03.pojo.entity.User;
import com.wei.study03.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

@SpringBootTest
class UserServiceTests {
    @Autowired
    UserService service;

    @Test
    void md5() {
        String salt = "qweqwew12312312aqweq";
        String pasword = "123456";
        String md5 = getMd5(salt,pasword);
        System.out.println("加密后的密码为：" + md5);
    }

    public String getMd5(String salt, String password){
        for (int i = 0; i < 3; i++) {
            // 调用md5加密算法将密码和盐值拼接在一起后进行加密
            password = DigestUtils.md5DigestAsHex((salt + password).getBytes());
        }
        return password;
    }

    @Test
    void reg(){
        UserDTO user = new UserDTO();
        user.setUsername("ts");
        user.setPassword("123");
        int rows = service.insertUser(user);
        System.out.println("注册成功，返回值为：" + rows);
    }

}
