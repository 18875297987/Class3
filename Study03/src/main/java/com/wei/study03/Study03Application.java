package com.wei.study03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

// 此注解可以让项目中filter过滤器生效
@ServletComponentScan
@SpringBootApplication
public class Study03Application {

    public static void main(String[] args) {
        SpringApplication.run(Study03Application.class, args);
    }

}
