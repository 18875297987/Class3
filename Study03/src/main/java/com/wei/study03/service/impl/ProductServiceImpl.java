package com.wei.study03.service.impl;

import com.wei.study03.mapper.ProductMapper;
import com.wei.study03.pojo.dto.ProductDTO;
import com.wei.study03.pojo.entity.Product;
import com.wei.study03.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper mapper;

    @Override
    public int insert(ProductDTO productDTO) {
        Product product = new Product();
        BeanUtils.copyProperties(productDTO,product);

        product.setUrl("/product/"+product.getUrl());
        product.setCreated(new Date());

        if (mapper.insert(product) != 1){
            return 601;//数据库异常
        }

        return 602;
    }
}
