package com.wei.web.mapper;

import com.wei.web.entity.RegUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user_test where username = #{username}")
    RegUser selectByUserName(String username);

    @Insert("insert into user_test values(#{username},#{password},#{nickname})")
    int insert(RegUser user);
}
