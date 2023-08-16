package newDateApi;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Set;

/**
 * Instant 时间戳
 * 它是以Unix元年(传统 的设定为UTC时区 1970年1月1日午夜时分)开始 所经历的描述进行运算
 * ZoneId 时区
 */
public class InstantAndZoneId {
    public static void main(String[] args) {
        //时间戳
        Instant now = Instant.now();
        System.out.println(now);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant now2 = Instant.now();
        System.out.println(now2);
        long millis = Duration.between(now, now2).toMillis();
        System.out.println(millis);
        System.out.println("----------------------------------------------------");

        //时区
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        availableZoneIds.stream().filter(s -> s.contains("Asia")).forEach(System.out::println);
        ZoneId id = ZoneId.of("Asia/Shanghai");
        System.out.println(id.getRules());
    }
}
