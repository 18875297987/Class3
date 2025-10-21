package com.wei.study03.config;

import com.wei.study03.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

// @Configuration 将当前类作为系统配置类添加到框架配置中
@Configuration
public class InterceptorConfigration  implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 配置白名单
        List<String> list = new ArrayList<>();
        list.add("/user/login");
        list.add("/user/reg");
        list.add("/web/login.html");
        list.add("/web/register.html");
        list.add("/web/index.html");
        list.add("/web/product.html");
        list.add("/bootstrap3/**");
        list.add("/css/**");
        list.add("/images/**");
        list.add("/js/**");
        list.add("/web/js/**");

        // 将拦截器对象创建出来
        LoginInterceptor inter = new LoginInterceptor();

        registry.addInterceptor(inter) // 添加拦截器规则
                .excludePathPatterns(list) //添加不拦截的全部目录
                .addPathPatterns("/**"); // 添加拦截的路径，这里规则是拦截所有的HTML页面和请求

    }
}
