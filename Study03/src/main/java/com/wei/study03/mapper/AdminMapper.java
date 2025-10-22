package com.wei.study03.mapper;

import com.wei.study03.pojo.entity.Admin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminMapper {
    @Select("select * from admin where username = #{username} ")
    Admin selectByUsername(String username);

    @Insert("insert into admin values(null,#{username},#{password},#{salt}) ")
    int insert(Admin admin);
}
