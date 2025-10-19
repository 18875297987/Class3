package com.wei.study03;

import com.wei.study03.pojo.entity.User;
import com.wei.study03.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class UserMapperTests {
    @Autowired
    UserMapper userMapper;

    @Test
    void insert() {
        User user = new User();
        Date date1 = new Date();
        Date date2 = new Date();
        user.setUsername("zs");
        user.setPassword("123");
        /*
        * 设置盐值，需要知道盐值的作用：
        * 1.增加密码被破解的难度，盐值是一个随机生成的字符串，与密码组合后在进行加密
        * 由于盐值的随机性，即使两个用户使用相同的密码，但是由于盐值不同，所以经过盐值处理后
        * 得到的加密结果也完全不同，比如最简单的加密方式，就是直接将盐值和密码拼接在一起
        * 2.抵御字典攻击，字典攻击是一种常见的密码破解方法，攻击者使用预先准备好的包含大量常见
        * 密码的字典文件，对加密后的密码进行逐一尝试匹配，实现破解效果
        * 3.提高密码的唯一性和安全性，盐值为每个用户的密码增加了额外的随机性和唯一性，即使多个用户
        * 选择了相同的密码，由于各自盐值的不同，其加密后的密码也各不相同
        * */
        user.setSalt("qweqwe123123qwe");
        user.setIs_delete(1);
        user.setPhone("110");
        user.setEmail("110@qq.com");
        user.setGender(1);
        user.setAvater("qweqweqwe");
        user.setCreated_user("zs");
        user.setCreated_time(date1);
        user.setModified_user("zs");
        user.setModified_time(date2);
        int count = userMapper.insert(user);
        System.out.println("添加成功，数量为：" + count);
    }

    @Test
    void selectByUsername(){
        User user = userMapper.selectByUsername("zs");
        System.out.println(user);
    }

}
