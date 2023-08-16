package UpdatesInTryWithResources;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 实际做什么不重要，主要关注资源关闭方式
 */
public class FirstUpdatedSolutionInVersion7 {
    public static void main(String[] args) {
        char[] chars = new char[10];
        //在jdk7版本中，在try语句块⾥定义需要关闭的资源,最后可以实现资源的⾃动关闭,(省略了finally)
        //但是要求这一资源必须要在try⼦句中进行初始化
        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in)) {
            int read = inputStreamReader.read(chars);
            if (read != -1) {
                System.out.println(new String(chars));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
