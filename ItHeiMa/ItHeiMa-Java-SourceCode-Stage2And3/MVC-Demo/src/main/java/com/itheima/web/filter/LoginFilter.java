package com.itheima.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登陆验证的过滤器
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        //获取当前访问的资源路径
        String url = req.getRequestURL().toString();
        //判断该request的访问资源路径是否和登录注册相关,如果是,则放行
        String[] urls = {"/login.jsp", "/imgs/", "/css/", "/loginServlet", "/register.jsp", "/registerServlet", "/checkCodeServlet"};
        //循环判断
        for (String u : urls) {
            if (url.contains(u)) {
                //找到了
                //放行
                chain.doFilter(request, response);
                //break;
                return;
            }
        }

        // 若访问的是其他需要登陆的资源,则判断是否已经登陆
        //1. 判断session中是否有user
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");

        //2. 判断user是否为null
        if (user != null) {
            // 登录过了 放行
            chain.doFilter(request, response);
        } else {
            // 没有登陆，存储提示信息，跳转到登录页面
            req.setAttribute("login_msg", "您尚未登陆！");
            req.getRequestDispatcher("/login.jsp").forward(req, response);
        }

    }
}
