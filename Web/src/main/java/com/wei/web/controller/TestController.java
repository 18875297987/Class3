package com.wei.web.controller;

import com.wei.web.entity.Emp;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*RestController:声明这个是当前项目的控制类，它的作用是负责前后端的数据交互*/
/*添加注解的作用是告诉Springboot项目，这是一个控制类，那么后面客户端发送过来的请求
* 服务器就会在控制类寻找是否有同样的地址来进行接收
* */
@RestController
public class TestController {
    // a标签测试
    @RequestMapping("/test")
    public String test(){
        return "login.html";
    }

    @RequestMapping("/test1")
    public String test1(String a ,String b){
        return "第一个文本框输入的是：" + a + ",第二个文本框输入的是：" + b;
    }

    @RequestMapping("/test2")
    public String test2(String title,String price){
        return "商品名称：" + title + ",商品价格：" + price;
    }

    @RequestMapping("/test3")
    public Emp test3(@RequestBody Emp emp){
        System.out.println("接收了客户端发送过来的对象:"+emp);
        return emp;
    }

}
