package IO.ConvertedIO;


import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * 使用转换流可以指定编码表,解决乱码问题，但是只能解决读取文件的乱码问题，不能解决写入文件的乱码问题。
 * 并且在JDK11后，转换流已经被废弃了。更好的做法是直接在字符流的构造参数中指定字符编码，字符编码推荐使用java.nio.charset.Charset类来表示。
 */
public class ConvertedDemo1 {
    public static void main(String[] args) throws IOException {
        //method1();
        //method2();

        //在JDK11之后,字符流新推出了一个构造,也可以指定编码表
        FileReader fr = new FileReader("C:\\Users\\apple\\Desktop\\a.txt", Charset.forName("gbk"));
        int ch;
        while ((ch = fr.read()) != -1) {
            System.out.println((char) ch);
        }
        fr.close();
    }

    private static void method2() throws IOException {
        //如何解决乱码现象
        //文件是什么码表,那么咱们就必须使用什么码表去读取.
        //我们就要指定使用GBK码表去读取文件.
        InputStreamReader isr = new InputStreamReader(new FileInputStream("C:\\Users\\apple\\Desktop\\a.txt"), "gbk");
        int ch;
        while ((ch = isr.read()) != -1) {
            System.out.println((char) ch);
        }
        isr.close();


        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("C:\\Users\\apple\\Desktop\\b.txt"), StandardCharsets.UTF_8);
        osw.write("我爱学习,谁也别打扰我");
        osw.close();
    }

    //这个方法直接读取会产生乱码
    //因为文件是GBK码表
    //而idea默认的是UTF-8编码格式.
    //所以两者不一致,导致乱码
    private static void method1() throws IOException {
        FileReader fr = new FileReader("C:\\Users\\apple\\Desktop\\a.txt");
        int ch;
        while ((ch = fr.read()) != -1) {
            System.out.println((char) ch);
        }
        fr.close();
    }


}
