package com.wei.study03.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.wei.study03.pojo.entity.Category;
import com.wei.study03.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService service;

    @GetMapping("/insert")
    @ApiOperation("01.添加分类")
    @ApiOperationSupport(order = 100)
    public List<Category> insert(String name){
        return service.insert(name);
    }

    @GetMapping("/select")
    @ApiOperation("02.查询分类")
    @ApiOperationSupport(order = 200)
    public List<Category> select(){
        return service.select();
    }

    @GetMapping("/deleteById")
    @ApiOperation("03.删除分类")
    @ApiOperationSupport(order = 300)
    public int insert(int id){
        return service.deleteById(id);
    }

    @PostMapping("/update")
    @ApiOperation("04.修改分类名称")
    @ApiOperationSupport(order = 400)
    public int update(@RequestBody Category category){
        return service.update(category);
    }

}
