package com.wei.study03.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.wei.study03.pojo.dto.AdminDTO;
import com.wei.study03.service.AdminService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService service;

    @PostMapping("/insert")
    @ApiOperation("01.添加管理员用户")
    @ApiOperationSupport(order = 100)
    public int insert(@RequestBody AdminDTO adminDTO){
        return service.insert(adminDTO);
    }

    @PostMapping("/login")
    @ApiOperation("02.管理员登录")
    @ApiOperationSupport(order = 200)
    public int login(@RequestBody AdminDTO adminDTO, @ApiIgnore HttpSession session){
        int result = service.login(adminDTO);
        if (result == 603){
            session.setAttribute("username", adminDTO.getUsername());
            session.setAttribute("admin",adminDTO.getUsername());
        }

        return result;

    }

}
