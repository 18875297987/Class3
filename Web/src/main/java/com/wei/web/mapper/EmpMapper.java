package com.wei.web.mapper;


import com.wei.web.entity.Emp2;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpMapper {
    @Insert("insert into emp values(null,#{name},#{age},#{salary},#{gender},#{job})")
    int insert(Emp2 emp2);

}
