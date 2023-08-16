package UpdatesInTryWithResources;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 实际做什么不重要，主要关注资源关闭方式
 */
public class NowWithVersion9Updates {
    public static void main(String[] args) {
        char[] chars = new char[10];
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        //jdk9后，允许资源定义在外部，如果有多个资源，中间使⽤分号间隔
        try (inputStreamReader) {
            int read = inputStreamReader.read(chars);
            if (read != -1) {
                System.out.println(new String(chars));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
