package streamapiExtended;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Steam的并行操作(多线程)
 */
public class ParallelStream {
    public static void main(String[] args) {
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        System.out.println("----------串行------------");
        long t1 = System.currentTimeMillis();
        long count = values.stream().sorted().count();
        System.out.println(count);
        long t2 = System.currentTimeMillis();
        long millis = t2 - t1;
        System.out.println(millis);

        System.out.println("-------------并行----------------");
        long t3 = System.currentTimeMillis();
        //parallelStream()是Collection接口的方法
        long count2 = values.parallelStream().sorted().count();
        System.out.println(count2);
        long t4 = System.currentTimeMillis();
        long millis2 = t4 - t3;
        System.out.println(millis2);
    }
}
