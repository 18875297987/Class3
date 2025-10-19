package com.wei.web.entity;


import lombok.Data;


/*
* Lombok是一款java开发工具库，核心作用是通过注解自动生成java类中重复的代码
* 如：Getter/Setter、构造方法、toString
* 减少冗余代码，提升开发效率
* 只需要在实体类上添加@Data注解，那么后面再使用时，Lombok会自动给我们生成Getter/Setter、构造方法、toString
* */

@Data
public class Emp2 {
    private int id;
    private String name;
    private int age;
    private Double salary;
    private char gender;
    private String job;

}
