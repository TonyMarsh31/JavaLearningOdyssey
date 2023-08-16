package socketDemo.UDPDemo.socketdemo1;


import java.net.InetAddress;
import java.net.UnknownHostException;


public class InetAddressDemo1 {
    public static void main(String[] args) throws UnknownHostException {
        //static InetAddress getByName (String host) 确定主机名称的IP地址。主机名称可以是机器名称，也可以是IP地址
        InetAddress address = InetAddress.getByName("localhost");//或者输入你本机的ip地址

        //String getHostName ()     获取此IP地址的主机名
        String hostName = address.getHostName();
        System.out.println("主机名为" + hostName);

        //String getHostAddress ()  返回文本显示中的IP地址字符串
        String ip = address.getHostAddress();
        System.out.println("IP为" + ip);
    }
}
