package com.wei.study03.pojo.entity;

import lombok.Data;

@Data
public class Admin {
     private int id;
     private String username;
     private String password;
     private String salt;
}
