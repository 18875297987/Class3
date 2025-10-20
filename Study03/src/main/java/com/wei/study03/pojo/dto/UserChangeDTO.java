package com.wei.study03.pojo.dto;

import lombok.Data;

@Data
public class UserChangeDTO {
    private String username;
    private String phone;
    private String email;
    private int gender;
}
