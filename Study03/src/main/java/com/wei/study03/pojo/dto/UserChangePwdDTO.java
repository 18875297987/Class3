package com.wei.study03.pojo.dto;

import lombok.Data;

@Data
public class UserChangePwdDTO {
    private String oldPassword;
    private String newPassword;
}
