package com.wei.study03.service.impl;

import com.wei.study03.mapper.CategoryMapper;
import com.wei.study03.pojo.entity.Category;
import com.wei.study03.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategroyServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper mapper;

    @Override
    public List<Category> select() {
        return mapper.select();
    }

    @Override
    public int deleteById(int id) {
        return mapper.deleteById(id);
    }

    @Override
    public int update(Category category) {
        return mapper.update(category);
    }

    @Override
    public List<Category> insert(String name) {
        mapper.insert(name);
        return mapper.select();
    }
}
