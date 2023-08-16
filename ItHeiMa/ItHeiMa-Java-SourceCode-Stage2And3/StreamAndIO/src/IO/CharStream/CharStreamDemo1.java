package IO.CharStream;

import java.io.FileInputStream;
import java.io.IOException;
// 使用字节输入流读取中文文件，出现乱码
public class CharStreamDemo1 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("charstream\\a.txt");
        int b;
        while ((b = fis.read()) != -1) {
            System.out.println((char) b);
        }
        fis.close();
    }
}
