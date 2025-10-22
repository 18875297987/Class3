package com.wei.study03.service.impl;

import com.wei.study03.mapper.AdminMapper;
import com.wei.study03.pojo.dto.AdminDTO;
import com.wei.study03.pojo.entity.Admin;
import com.wei.study03.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.wei.study03.util.Md5Utils.getMd5;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper mapper;
    public int insert(AdminDTO adminDTO) {
        Admin sqlAdmin = mapper.selectByUsername(adminDTO.getUsername());
        if (sqlAdmin != null){
            return 601;
        }
        String salt = UUID.randomUUID().toString();
        String md5Password = getMd5(salt,adminDTO.getPassword());

        sqlAdmin = new Admin();

        sqlAdmin.setUsername(adminDTO.getUsername());
        sqlAdmin.setPassword(md5Password);
        sqlAdmin.setSalt(salt);
        if (mapper.insert(sqlAdmin) != 1){
            return 603;
        }
        return 602;
    }
    public int login(AdminDTO adminDTO) {
        Admin sqlAdmin = mapper.selectByUsername(adminDTO.getUsername());
        if (sqlAdmin == null){
            return 601;
        }
        String salt = sqlAdmin.getSalt();
        String md5Password = getMd5(salt,adminDTO.getPassword());
        if (!md5Password.equals(sqlAdmin.getPassword())){
            return 602;
        }

        return 603;
    }
}
