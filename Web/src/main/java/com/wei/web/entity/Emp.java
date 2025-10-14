package com.wei.web.entity;

public class Emp {
    private String title;
    private String price;

    /*在Springboot项目中用来接收客户端数据的实体类，必须要创建以下方法：
    * 1.无参构造方法
    * 2.全参构造方法
    * 3.每一个字段的get和set方法
    * 4.toString方法
    * 否则，会出现不能接收数据的情况
    * */

    public Emp() {
    }

    public Emp(String title, String price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "title='" + title + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
