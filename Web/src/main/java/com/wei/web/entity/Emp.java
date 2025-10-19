package com.wei.web.entity;

public class Emp {
    private String name;
    private String job;
    /*在Springboot项目中用来接收客户端数据的实体类，必须要创建以下方法：
    * 1.无参构造方法
    * 2.全参构造方法
    * 3.每一个字段的get和set方法
    * 4.toString方法
    * 否则，会出现不能接收数据的情况
    * */
    public Emp() {
    }
    public Emp(String name, String job) {
        this.name = name;
        this.job = job;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }
    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
