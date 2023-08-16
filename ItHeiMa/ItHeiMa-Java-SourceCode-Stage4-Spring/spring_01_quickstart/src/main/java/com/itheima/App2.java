package com.itheima;

import com.itheima.dao.BookDao;
import com.itheima.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App2 {
    public static void main(String[] args) {
        // 获取SpringIOC容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 从容器中获取对象,即Bean
        BookDao dao = (BookDao) ac.getBean("bookDao");
        // 调用方法
        dao.save();
        // 同理获取Service对象
        BookService service = (BookService) ac.getBean("bookService");
        service.save();
    }
}
