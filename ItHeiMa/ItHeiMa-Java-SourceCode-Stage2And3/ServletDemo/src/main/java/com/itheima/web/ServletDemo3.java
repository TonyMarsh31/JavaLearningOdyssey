package com.itheima.web;


import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet 方法介绍
 */
@WebServlet(urlPatterns = "/demo3", loadOnStartup = 1)
public class ServletDemo3 implements Servlet {
    private ServletConfig config;

    /**
     * 初始化方法
     * 1. 调用时机：默认情况下，Servlet被第一次访问时，调用
     * * loadOnStartup:
     * 2. 调用次数：1次
     *
     * @param config
     */
    @Override
    public void init(ServletConfig config) {
        this.config = config;
        System.out.println("init...");
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    /**
     * 提供服务
     * 1. 调用时机：每一次Servlet被访问时，调用
     * 2. 调用次数：多次
     *
     * @param req
     * @param res
     */
    @Override
    public void service(ServletRequest req, ServletResponse res) {
        System.out.println("servlet hello world~");
    }


    /**
     * 销毁方法
     * 1. 调用时机：内存释放或者服务器关闭的时候，Servlet对象会被销毁，调用
     * 2. 调用次数：1次
     */
    @Override
    public void destroy() {
        System.out.println("destroy...");
    }

    @Override
    public String getServletInfo() {
        return "";
    }


}
