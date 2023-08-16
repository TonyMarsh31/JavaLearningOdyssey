package UpdatesInInputStream;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Objects;

/**
 * InputStream 更新了⼀个⾮常有⽤的⽅法：transferTo
 * 可以⽤来将数据直接传输到OutputStream，这是在处理原始数据流时⾮常常⻅的⼀种⽤法。
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        //仅演示transferTo的⽅法,实际目录下没有a.txt和b.txt文件
        new Demo().test();
    }

    public void test() throws Exception {
        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("a.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("src/b.txt");
        try (resourceAsStream; fileOutputStream) {
            //把输⼊流中的所有数据直接⾃动复制到输出流中
            Objects.requireNonNull(resourceAsStream).transferTo(fileOutputStream);
        }
    }
}
