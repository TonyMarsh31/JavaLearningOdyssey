package UpdatesInStreamAPI;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream API 更新的一些新方法
 */
public class Demo {
    public static void main(String[] args) {
        Stream.of("a", "b", "c", "", "e", "f").takeWhile(s -> !s.isEmpty())
                .forEach(System.out::print);
        System.out.println("\n--------------");

        Stream.of("a", "b", "c", "", "e", "f").dropWhile(s -> !s.isEmpty())
                .forEach(System.out::print);
        System.out.println("\n--------------");

        IntStream.iterate(3, x -> x < 10, x -> x + 3)
                .forEach(System.out::print);
        System.out.println("\n--------------");

        long count = Stream.ofNullable(100).count();
        System.out.println(count);

        count = Stream.ofNullable(null).count();
        System.out.println(count);

    }
}
