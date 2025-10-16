package com.wei.web.mapper;


import com.wei.web.entity.Emp2;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmpMapper {
    @Insert("insert into emp values(null,#{name},#{age},#{salary},#{gender},#{job})")
    int insert(Emp2 emp2);

    @Delete("delete from emp where id = #{index}")
    int deleteById(int index);

    @Update("update emp set name=#{name},age=#{age}," +
            "salary=#{salary},gender=#{gender},job=#{job}" +
            "where id = #{id}")
    int update(Emp2 emp2);

    @Select("select * from emp")
    List<Emp2> select();

    @Select("select * from emp where id = #{id}")
    Emp2 selectById(int id);


}
