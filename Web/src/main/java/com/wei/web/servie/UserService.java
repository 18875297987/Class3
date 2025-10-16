package com.wei.web.servie;
import com.wei.web.entity.RegUser;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;


/*
分层的概念：
* SpringBoot项目核心分层遵循“职责单一”原则，从下到岛上依次为：DAO层、Service层、Controller层、Entity层
  各层核心职责与作用：
  Entity层（实体层）：映射数据库表结构，实体类中的成员变量与表字段一一对应，是各层间传递数据的“载体”（如：regUser、Emp2）
  DAO层（数据访问层）：负责直接操作数据库仅做“增删改查”基础操作，不包含业务逻辑，常用Mapper接口实现
  Controller层（控制层）：接收前端请求，调用Service层方法处理业务，最后返回结果给前端
  Service层（业务逻辑层）:调用DAO层接口，封装核心业务逻辑（如用户注册时的“校验手机号+保存用户”组合操作）
                        通常分为接口（Sesrvice）和实现类(ServiceImpl)
                        它最重要的一个功能就是便于解耦和扩展
* */

public interface UserService {
    int reg(RegUser user);
    int login(RegUser user);
    String getNickname(RegUser user);
    RegUser getUser(String username);
    int change(RegUser user);
}
