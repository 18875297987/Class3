package com.wei.study03.service;

import com.wei.study03.pojo.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> select();
    int deleteById(int id);
    int update(Category category);
    List<Category> insert(String name);
}
