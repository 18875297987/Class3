package com.wei.study03.service;

import com.wei.study03.pojo.dto.ProductDTO;
import com.wei.study03.pojo.vo.ProductAdminVO;

import java.util.List;

public interface ProductService {
    int insert(ProductDTO productDTO);
    List<ProductAdminVO> select();
}
