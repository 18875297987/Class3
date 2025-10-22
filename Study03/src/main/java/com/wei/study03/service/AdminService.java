package com.wei.study03.service;

import com.wei.study03.pojo.dto.AdminDTO;

public interface AdminService {
    int insert(AdminDTO adminDTO);
    int login(AdminDTO adminDTO);
}
