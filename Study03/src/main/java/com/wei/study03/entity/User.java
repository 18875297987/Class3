package com.wei.study03.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String salt;
    private int is_delete;
    private String phone;
    private String email;
    private int gender;
    private String avater;
    private String created_user;
    private Date created_time;
    private String modified_user;
    private Date modified_time;

}
