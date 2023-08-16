package com.st.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

//地址：ws://localhost:22599/websocket/{sid}, sid stands for session id
@ServerEndpoint("/websocket/{sid}")
@Component
public class WebSocketServer {

    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    //基于CAS的线程安全的原子整数类型
    private static AtomicInteger onlineNum = new AtomicInteger();

    //concurrent包的线程安全HashMap，用来存放每个客户端对应的WebSocket的SessionId。
    //{sid:session}
    private static ConcurrentHashMap<String, Session> sessionPools = new ConcurrentHashMap<>();

    //发送消息
    public static void sendMessage(Session session, String message) throws IOException {
        if (session != null) {
            synchronized (session) {
                session.getBasicRemote().sendText(message);
            }
        }
    }

    //给指定用户发送消息
    public void sendInfo(String userName, String message) {
        Session session = sessionPools.get(userName);
        try {
            sendMessage(session, message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //建立连接成功调用
    @OnOpen
    public void onOpen(Session session, @PathParam("sid") String userName) {
        sessionPools.put(userName, session);
        onlineNum.incrementAndGet();
        System.out.println("有新连接加入！当前在线人数为" + onlineNum.get());
        try {
            sendMessage(session, "欢迎您，" + userName + "！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //关闭连接调用
    @OnClose
    public void onClose(@PathParam("sid") String userName) {
        sessionPools.remove(userName);
        onlineNum.decrementAndGet();
        System.out.println("有一连接关闭！当前在线人数为" + onlineNum.get());
    }

    //收到客户端消息时调用
    @OnMessage
    public void onMessage(String message) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        //将json字符串转换成map对象
        Map<String, String> map = objectMapper.readValue(message, new TypeReference<Map<String, String>>() {});

        Session session = sessionPools.get(map.get("toUserId"));
        if (session != null) {
            try {
                sendMessage(session, map.get("sendMsg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //错误时调用
    @OnError
    public void onError(Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }

}
