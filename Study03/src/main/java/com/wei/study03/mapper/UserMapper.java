package com.wei.study03.mapper;

import com.wei.study03.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    @Insert("insert into user values(" +
            "null,#{username},#{password},#{salt}" +
            ",#{is_delete},#{phone},#{email}" +
            ",#{gender},#{avater},#{created_user}" +
            ",#{created_time},#{modified_user},#{modified_time}" +
            ")")
    int insert(User user);
}
