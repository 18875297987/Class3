package com.wei.study03.mapper;

import com.wei.study03.pojo.entity.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
    @Insert("insert into product values" +
            "(null,#{title},#{price}" +
            ",#{old_price},#{sale_count},#{num}" +
            ",#{category_id},#{url},#{created})")
    int insert(Product product);
}
