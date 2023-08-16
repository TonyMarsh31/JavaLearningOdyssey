package Base64;

import java.util.Base64;

/**
 * 一个简单的Base64演示程序
 */
public class Demo {
    public static void main(String[] args) {
        //基本加密
        String str = "Hello";
        //编码
        String s = Base64.getEncoder().encodeToString(str.getBytes());
        System.out.println(s);
        //解码
        byte[] decode = Base64.getDecoder().decode(s);
        System.out.println("解码:" + new String(decode));
    }
}
