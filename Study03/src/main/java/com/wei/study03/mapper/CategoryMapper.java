package com.wei.study03.mapper;

import com.wei.study03.pojo.entity.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryMapper {
    @Insert("insert into category values(null,#{name}) ")
    int insert(String name);

    @Select("select * from category ")
    List<Category> select();

    @Delete("delete from category where id = #{id} ")
    int deleteById(int id);

    @Update("update category set name=#{name} where id = #{id} ")
    int update(Category category);


}
