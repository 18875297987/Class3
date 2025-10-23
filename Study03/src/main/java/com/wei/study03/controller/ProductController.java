package com.wei.study03.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.wei.study03.pojo.dto.ProductDTO;
import com.wei.study03.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService service;

    @PostMapping("/insert")
    @ApiOperation("01.添加商品")
    @ApiOperationSupport(order = 100)
    public int insert(@RequestBody ProductDTO productDTO){
        return service.insert(productDTO);
    }
}
