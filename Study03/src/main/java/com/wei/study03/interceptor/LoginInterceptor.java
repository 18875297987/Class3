package com.wei.study03.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    // HttpServletRequest request： HTTP请求对象
    // HttpServletResponse response：HTTP响应对象 => 负责数据返回，以及页面跳转
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 验证登录状态
        if (request.getSession().getAttribute("username") == null){
            // 没登录
            // 重定向（重新定义访问的网址），让用户跳转到登录页
            response.sendRedirect("/web/login.html");
            System.out.println("用户未登录，所以拦截了页面，让用户跳转到登录页面");
            return false; // 表示拦截
        }
        return true; // 表示不拦截

    }
}
