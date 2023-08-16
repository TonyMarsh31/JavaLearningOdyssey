package IO.ConvertedIO;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 对象流的使用场景引入:先看看不使用对象流的做法
 */
public class ConvertedDemo2 {
    public static void main(String[] args) throws IOException {
        User user = new User("zhangsan", "qwer");
        //需求:把这个用户信息保存到本地文件去.
        BufferedWriter bw = new BufferedWriter(new FileWriter("a.txt"));
        bw.write(user.getUsername());
        bw.newLine();
        bw.write(user.getPassword());
        bw.close();
        //虽然是可行的，但当一个对象中包含的属性很多时，就会出现很多行，不方便
        //并且这些逻辑在读取的时候也要写一遍，不方便
    }
}
