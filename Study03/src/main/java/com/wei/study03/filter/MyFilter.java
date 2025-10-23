package com.wei.study03.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "MyFilter",urlPatterns = {
        "/admin/adminIndex.html",
        "/category/insert",
        "/category/deleteById",
        "/category/update",

        "/product/insert",
        "/upload/product",
        "/admin/insertProduct.html"
})
public class MyFilter implements Filter {
    // 请求到资源之前执行的方法
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("经过了过滤器");
        HttpServletRequest rt = (HttpServletRequest) servletRequest;
        HttpServletResponse re = (HttpServletResponse) servletResponse;
        // 得到会话对象
        HttpSession session = rt.getSession();

        String username = "";
        // 得到用户登录的用户对象
        try {
            username = session.getAttribute("admin").toString();
        }catch (NullPointerException n){
            username = null;
        }

        // 判断用户是否登录
        if (username != null){//值为true的话则为登录过
            filterChain.doFilter(servletRequest,servletResponse); // 放行
        }else { // 用户未登录
            // 让客户端重定向到登录页面
            re.sendRedirect("/admin/admin.html");
        }
    }

    // 初始化时执行的方法
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    // 销毁时执行的方法
    @Override
    public void destroy() {}
}
