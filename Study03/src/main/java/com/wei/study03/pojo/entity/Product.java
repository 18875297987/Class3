package com.wei.study03.pojo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Product {
    private int id;
    private String title;
    private double price;
    private double old_price;
    private int sale_count;
    private int num;
    private int category_id;
    private String url;
    private Date created;
}
