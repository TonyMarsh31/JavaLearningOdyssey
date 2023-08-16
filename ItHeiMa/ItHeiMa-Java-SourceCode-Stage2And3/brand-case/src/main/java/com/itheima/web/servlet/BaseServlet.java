package com.itheima.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用于替换HttpServlet, 用于简化Servlet的开发,请求的分发不再根据请求的方法如get、post来分发,而是根据请求的路径来分发
 */
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.先获取请求的访问路径
        String uri = req.getRequestURI(); // 一般是:projectName/servletName/methodName
        // 2.筛选出方法名称
        String methodName = uri.substring(uri.lastIndexOf("/") + 1); // +1 because we don't want the slash
        // 3.根据方法名称使用反射机制获取对象Method,并执行
        try {
            // getDeclaredMethod() will return the method even if it is private
            this.getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class).invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
