package com.wei.study03.pojo.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private String title;
    private double price;
    private double old_price;
    private int sale_count;
    private int num;
    private int category_id;
    private String url;
}
