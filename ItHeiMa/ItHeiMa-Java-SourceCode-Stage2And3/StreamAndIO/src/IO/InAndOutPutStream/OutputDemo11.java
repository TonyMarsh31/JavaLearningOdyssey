package IO.InAndOutPutStream;

import java.io.*;

public class OutputDemo11 {
    public static void main(String[] args) throws IOException {

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:\\itcast\\字节流复制图片.avi"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("myByteStream\\字节流复制图片.avi"));
        int len;
        while ((len = bis.read()) != -1) {
            bos.write(len);
        }

        bos.close();
        bis.close();
    }
}
