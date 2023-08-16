package newDateApi;

import java.time.LocalDateTime;

/**
 * 本地化日期时间 API
 * 当不需要考虑时区时，使用LocalDate/LocalTime 和 LocalDateTime 可以胜任你需要的所有日期操作。
 * LocalDate、LocalTime、LocalDateTime 类的实例是不可变的对象
 * 分别表示使用 ISO-8601日历系统的日期、时间、日期和时间。
 * 它们提供了简单的日期或时间，并不包含当前的时间信息。也不包含与时区相关的信息。
 */
public class LocalAPI {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        //指定时间
        LocalDateTime time = LocalDateTime.of(2022, 8, 17, 10, 20);
        System.out.println(time);
        //时间运算
        LocalDateTime localDateTime = time.plusDays(3);
        System.out.println(localDateTime);
        LocalDateTime localDateTime1 = time.minusHours(3);
        System.out.println(localDateTime1);
        //单独获得某个字段的信息
        System.out.println(now.getYear());
        System.out.println(now.getHour());
    }
}
