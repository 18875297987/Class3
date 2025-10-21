package com.wei.study03.service;

import com.wei.study03.pojo.dto.UserChangeDTO;
import com.wei.study03.pojo.dto.UserChangePwdDTO;
import com.wei.study03.pojo.dto.UserDTO;
import com.wei.study03.pojo.entity.User;
import com.wei.study03.pojo.vo.UserInfoVO;

public interface UserService {
    int insertUser(UserDTO userDTO);
    int chackUser(UserDTO userDTO);
    int changeUserInfo(UserChangeDTO userChangeDTO);
    UserInfoVO selectByUsername(String username);
    int changeUserAvater(String username,String avaterName);
    String getAvater(String username);
    int changeUserPassword(UserChangePwdDTO pwdDTO, String username);
}
