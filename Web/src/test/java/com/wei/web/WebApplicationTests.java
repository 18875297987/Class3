package com.wei.web;

import com.wei.web.entity.Emp2;
import com.wei.web.mapper.EmpMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class WebApplicationTests {
    // 自动注入，想要使用接口，就必须要给接口添加实现类
    // 而加上自动注入Autowired注解后，
    // Springboot会自动的帮我们去创建这个实现类
    @Autowired
    EmpMapper empMapper;

    @Test
    void insert() {
        Emp2 emp2 = new Emp2();
        emp2.setName("小黑子");
        emp2.setAge(99);
        emp2.setSalary(100000.0);
        emp2.setGender('男');
        emp2.setJob("艺人身份赋能营销师");

        int count = empMapper.insert(emp2);
        System.out.println("数据添加成功，添加数量为：" + count);
    }

    @Test
    void deleteById(){
        int count = empMapper.deleteById(3);
        System.out.println("数据操作成功，数量为：" + count);
    }

    @Test
    void update(){
        Emp2 emp2 = new Emp2();
        emp2.setId(2);
        emp2.setName("鸡爪");
        emp2.setAge(5);
        emp2.setSalary(10000.0);
        emp2.setGender('女');
        emp2.setJob("假粉丝");
        int count = empMapper.update(emp2);
        System.out.println("数据操作成功，数量为：" + count);
    }

    @Test
    void select(){
        List<Emp2> empArr = empMapper.select();
        for (Emp2 emp2 : empArr){
            System.out.println(emp2);
        }
    }

    @Test
    void selectById(){
        Emp2 emp2 = empMapper.selectById(1);
        System.out.println(emp2);
    }



}
