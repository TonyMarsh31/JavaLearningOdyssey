package socketDemo.TCPDemo.socketdemo7ImprovedOne;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10000);

        Socket accept = ss.accept();

        InputStream is = accept.getInputStream();
        int b;
        while ((b = is.read()) != -1) { // 注意如果没收到结束标记，则read方法会阻塞
            System.out.println((char) b);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
        bw.write("你谁啊?");
        bw.newLine();
        bw.flush();

        bw.close();
        is.close();
        accept.close();
        ss.close();
        // 显然，代码还有很多优化的地方，首当其冲的自然是用try catch语句优化代码结构，这么多close方法我很想把他们统一放到finally语句块里
        // 以及，使用多线程来使得我们的Server可以同时连接多个client
        // (之后会学习多线程场景的更好的解决方案NIO，不过目前你也可以直接用已经学过的线程池等技术做暂时的优化)
    }
}
