package com.wei.study03.service;

import com.wei.study03.pojo.dto.UserChangeDTO;
import com.wei.study03.pojo.dto.UserDTO;
import com.wei.study03.pojo.entity.User;

public interface UserService {
    int insertUser(UserDTO userDTO);
    int chackUser(UserDTO userDTO);
    int changeUserInfo(UserChangeDTO userChangeDTO);
    User selectByUsername(String username);
}
