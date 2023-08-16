package com.itheima.web;


import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/demo5")
public class ServletDemo5 extends MyHttpServlet {

    @Override
    protected void doGet(ServletRequest req, ServletResponse res) {
        System.out.println("get。。。。");
    }

    @Override
    protected void doPost(ServletRequest req, ServletResponse res) {
        System.out.println("post。。。。");
    }
}
