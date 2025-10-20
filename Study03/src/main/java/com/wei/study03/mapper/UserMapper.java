package com.wei.study03.mapper;

import com.wei.study03.pojo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    @Insert("insert into user values(" +
            "null,#{username},#{password},#{salt}" +
            ",#{is_delete},#{phone},#{email}" +
            ",#{gender},#{avater},#{created_user}" +
            ",#{created_time},#{modified_user},#{modified_time}" +
            ")")
    int insert(User user);

    @Select("select * from user where username = #{username}")
    User selectByUsername(String username);

    @Update("update user set phone=#{phone},email=#{email},gender=#{gender} where username=#{username}")
    int updateInfoByUsername(User user);

}
