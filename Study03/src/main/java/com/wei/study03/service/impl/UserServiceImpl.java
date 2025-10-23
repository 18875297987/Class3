package com.wei.study03.service.impl;

import com.wei.study03.pojo.dto.UserChangeDTO;
import com.wei.study03.pojo.dto.UserChangePwdDTO;
import com.wei.study03.pojo.dto.UserDTO;
import com.wei.study03.pojo.entity.User;
import com.wei.study03.mapper.UserMapper;
import com.wei.study03.pojo.vo.UserInfoVO;
import com.wei.study03.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

import static com.wei.study03.util.Md5Utils.getMd5;


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

    // 用户登录业务
    @Override
    public int chackUser(UserDTO userDTO) {
        // 用户名可能不存在
        // 1.将用户传入的数据执行查询
        User dataUser = mapper.selectByUsername(userDTO.getUsername());
        // 2.如果查询到了值，表示用户存在，没查询到值为null，表示用户名不存在
        if (dataUser == null){
            return 601; // 表示用户名不存在
        }
        // 密码有可能出现错误
        // 3.取出客户端传入的密码
        String inputPassword = userDTO.getPassword();
        // 4.取出数据库中的密码
        String sqlPassword = dataUser.getPassword();
        // 5.将用户登录时传入的密码按照原方式进行加密
        // (1) 将salt盐值从数据库中取出
        String salt = dataUser.getSalt();
        // (2) 将用户输入的密码和盐值加在一起，加密密码
        String md5Password = getMd5(salt,inputPassword);
        // (3) 比较加密后的密码和数据库中的密码是否一致
        if ( !md5Password.equals(sqlPassword)){
            return 602;// 表示密码不一致
        }
        // 6.用户可能被封禁或是注销
        int isDelete = dataUser.getIs_delete();
        if (isDelete == 1){
            return 603; // 表示用户已注销
        }
        if (isDelete == 2){
            return 604; // 表示用户被封禁
        }

        return 605; // 表示登录成功
    }

    // 修改用户信息
    @Override
    public int changeUserInfo(UserChangeDTO userChangeDTO) {
        User user = new User();
        BeanUtils.copyProperties(userChangeDTO, user);

        // 修改数据
        int rows = mapper.updateInfoByUsername(user);
        if (rows == 0){
            return 601;// 数据库异常，修改失败
        }
        return 602; // 修改成功
    }

    // 获取用户个人信息
    @Override
    public UserInfoVO selectByUsername(String username) {
        User user = mapper.selectByUsername(username);
        UserInfoVO userInfoVO = new UserInfoVO();
        userInfoVO.setUsername(user.getUsername());
        userInfoVO.setPhone(user.getPhone());
        userInfoVO.setEmail(user.getEmail());
        userInfoVO.setGender(user.getGender());

        return userInfoVO;
    }

    //修改用户头像业务
    @Override
    public int changeUserAvater(String username, String avaterName) {
        User user = mapper.selectByUsername(username);
        user.setAvater("/avater/"+avaterName);

        // 修改数据
        int rows = mapper.updateAvaterByUsername(user);
        if (rows == 0){
            return 601; // 数据库异常
        }

        return 602; // 修改成功
    }

    // 获取用户头像地址业务
    @Override
    public String getAvater(String username) {
        User user = mapper.selectByUsername(username);
        return user.getAvater();
    }

    // 修改用户密码
    @Override
    public int changeUserPassword(UserChangePwdDTO pwdDTO, String username) {
        // 将用户传入的数据执行查询，获取要修改密码的用户信息
        User sqlUser = mapper.selectByUsername(username);
        // 取出客户端传入的原密码
        String inputOldPassword = pwdDTO.getOldPassword();
        // 取出用户信息的密码
        String sqlPassword = sqlUser.getPassword();
        // 将原密码按照原方式进行加密
        // 将salt从用户信息中取出
        String salt = sqlUser.getSalt();
        // 将原密码和盐值加在一起进行加密
        String md5Password = getMd5(salt, inputOldPassword);
        // 比较加密后的密码和用户信息的密码是否一致
        if (!md5Password.equals(sqlPassword)){
            return 601; // 密码不一致
        }

        // 如果密码相等，开始执行修改密码流程
        // 加密新密码
        String md5NewPassword = getMd5(salt, pwdDTO.getNewPassword());
        // 将新加密的密码重新给用户对象进行赋值
        sqlUser.setPassword(md5NewPassword);

        // 插入到数据库中
        int count = mapper.updatePasswordByUsername(sqlUser);
        if (count == 0){
            return 602; // 数据库异常
        }
        return 603; // 密码修改成功
    }
}
