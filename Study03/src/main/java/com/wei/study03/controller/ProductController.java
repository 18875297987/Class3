package com.wei.study03.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.wei.study03.pojo.dto.ProductDTO;
import com.wei.study03.pojo.vo.ProductAdminVO;
import com.wei.study03.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/select")
    @ApiOperation("02.商品列表")
    @ApiOperationSupport(order = 200)
    public List<ProductAdminVO> select(){
        return service.select();
    }

}
