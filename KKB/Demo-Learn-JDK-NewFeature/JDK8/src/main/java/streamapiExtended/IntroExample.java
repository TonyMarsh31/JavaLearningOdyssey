package streamapiExtended;

import java.util.ArrayList;
import java.util.List;

/**
 * 简单应用：统计一个字符串类型集合中，所有⻓度大于 3 的元素个数。
 */
public class IntroExample {
    public static void main(String[] args) {
        List<String> data = new ArrayList<>();
        data.add("abc");
        data.add("abcd");
        data.add("abcde");
        data.add("abcdef");
        data.add("abcdefg");
        data.add("abcdefgh");
        data.add("abcdefghi");
        data.add("abcdefghij");

        //传统实现
        int count = 0;
        for (String s : data) {
            if (s.length() > 3) {
                count++;
            }
        }

        //使用Stream API实现
        long count2 = data.stream().filter(s -> s.length() > 3).count();

        System.out.println(count);
        System.out.println(count2);

    }
}
