package streamapiExtended;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

/**
 * 创建Stream 代码示例
 */
public class CreateSteamExample {
    public static void main(String[] args) {
        //方法1：Stream.of()
        Stream<String> aa = Stream.of("aa", "bb", "cc", "dd");
        aa.forEach(System.out::println);

        //方法2：Arrays工具类
        String[] temp = {"aa", "bb", "ddd"};
        Stream<String> stream = Arrays.stream(temp);
        stream.forEach(System.out::println);

        //方法3：使用集合的Stream()方法
        ArrayList<Object> objects = new ArrayList<>();
        objects.add("ac");
        objects.add("ac");
        objects.add("ac");
        objects.stream().forEach(System.out::println);
        //当然如果只是要遍历的话，可以直接用.foreach不需要多一个步骤转换为stream

        //方法4:创建无限流
        //4.1 迭代
        Stream<Integer> iterate = Stream.iterate(0, n -> n + 2);
        iterate.limit(5).forEach(System.out::println);
        System.out.println("===========================");
        //4.2 生成
        Stream<Integer> generate = Stream.generate(() -> new Random().nextInt());
        generate.limit(5).forEach(System.out::println);
    }
}
