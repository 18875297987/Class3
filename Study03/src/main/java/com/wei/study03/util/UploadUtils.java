package com.wei.study03.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
public class UploadUtils {
    private UploadUtils(){}
    public static String upload(MultipartFile picFile,String ditPath) throws IOException {
        // 在上传的这个picFile文件对象中存储了各种信息
        // 得到原始文件的名称  a.jpg
        String fileName = picFile.getOriginalFilename();
        log.info("原文件名:{}" ,fileName);
        // 得到文件的类型
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        log.info("文件类型：{}",suffix);
        // 得到唯一的文件名
        fileName = UUID.randomUUID() + suffix;
        log.info("新文件名:{}",fileName);
        // 使用保存图片的文件路径新建一个文件对象
        File dirFile = new File(ditPath);
        // 判断如果文件夹不存在
        if (!dirFile.exists()){
            // 创建文件夹
            dirFile.mkdir();
        }

        // 得到完整的文件路径
        String filePath = ditPath + "/" + fileName;
        // 把文件保存到上面的路径中
        picFile.transferTo(new File(filePath));
        log.info("头像图片保存成功！");
        return fileName;
    }

    public static void remove(String fileName,String ditPath){
        log.info("要删除的文件名是：{}",fileName);
        // 删除文件
        new File(ditPath + "/" + fileName).delete();
    }

}
