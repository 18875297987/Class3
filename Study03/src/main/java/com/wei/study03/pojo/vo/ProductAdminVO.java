package com.wei.study03.pojo.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ProductAdminVO {
    private int id;
    private String title;
    private double price;
    private double oldPrice;
    private int saleCount;
    private int num;
    private int categoryName;
    private String url;
}
