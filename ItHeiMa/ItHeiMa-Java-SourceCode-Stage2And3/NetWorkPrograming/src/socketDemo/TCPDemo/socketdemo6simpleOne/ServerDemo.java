package socketDemo.TCPDemo.socketdemo6simpleOne;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        //1. 创建ServerSocket对象
        ServerSocket ss = new ServerSocket(10000);

        //2. 等待客户端连接
        Socket accept = ss.accept();

        //3.获得输入流对象
        InputStream is = accept.getInputStream();
        int b;
        while ((b = is.read()) != -1) {
            System.out.print((char) b);
        }

        //4.释放资源
        is.close();
        ss.close();
        // 补充说明：
        // 1.注意ServerSocket是用于accept其他Socket的，数据读取相关操作的主体是acceptedSocket而不是ServerSocket本身
        // 2.使用socket的流对象的close方法后,socket本身也会关闭，所以无需额外关闭socket本身
        // 3.如果只是想关闭流并附上结束符号，使用Socket.closeInput/Output()方法。
        // 4.本案例中使用的字节流，不支持aciII外的字符，如要传输的是中文字符会乱码，解决方法是使用转换流

    }
}
