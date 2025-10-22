package com.wei.study03.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.wei.study03.util.UploadUtils;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@Slf4j
@RestController
@RequestMapping("/upload")
public class UploadController {
    // 得到保存图片的文件夹路径
    String ditPath = "F:/XCTF/Student02/Project2/avater";

    @PostMapping("/avater")
    @ApiOperation("01.保存头像图片")
    @ApiOperationSupport(order = 100)
    public String upload(MultipartFile picFile) throws IOException {
        String fileName = UploadUtils.upload(picFile, ditPath);
        return fileName;
    }

    @GetMapping("/remove")
    @ApiOperation("02.删除头像图片")
    @ApiOperationSupport(order = 200)
    public void remove(String fileName){
        UploadUtils.remove(fileName,ditPath);
    }

}
