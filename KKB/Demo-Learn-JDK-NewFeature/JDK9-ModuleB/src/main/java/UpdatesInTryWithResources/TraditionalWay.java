package UpdatesInTryWithResources;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 实际做什么不重要，主要关注资源关闭方式
 */
public class TraditionalWay {
    public static void main(String[] args) {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        char[] chars = new char[10];
        try {
            int read = inputStreamReader.read(chars);
            if (read != -1) {
                System.out.println(new String(chars));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStreamReader.close();//手动写代码声明关闭资源
            } catch (IOException e) {
                // 同时还要处理关闭本身这一操作可能出现的异常
                e.printStackTrace();
            }
        }
    }
}
