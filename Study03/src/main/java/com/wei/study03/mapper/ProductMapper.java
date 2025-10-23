package com.wei.study03.mapper;

import com.wei.study03.pojo.entity.Product;
import com.wei.study03.pojo.vo.ProductAdminVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMapper {
    @Insert("insert into product values" +
            "(null,#{title},#{price}" +
            ",#{old_price},#{sale_count},#{num}" +
            ",#{category_id},#{url},#{created})")
    int insert(Product product);

    @Select("select p.id id,title,price,\n" +
            "       old_price oldPrice,sale_count saleCount,\n" +
            "        num,name,url\n" +
            "       from product p join category c on p.category_id = c.id")
    List<ProductAdminVO> select();

}
