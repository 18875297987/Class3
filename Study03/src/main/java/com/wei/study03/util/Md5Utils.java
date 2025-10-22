package com.wei.study03.util;

import org.springframework.util.DigestUtils;

public class Md5Utils {
    // 私有构造，禁止实例化
    private Md5Utils(){}

    public static String getMd5(String salt, String password){
        for (int i = 0; i < 3; i++) {
            // 调用md5加密算法将密码和盐值拼接在一起后进行加密
            password = DigestUtils.md5DigestAsHex((salt + password).getBytes());
        }
        return password;
    }

}
