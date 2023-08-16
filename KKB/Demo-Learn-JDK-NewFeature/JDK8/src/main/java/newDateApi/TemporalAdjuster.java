package newDateApi;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * 时间校正器
 */
public class TemporalAdjuster {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now);
        //下周五
        LocalDate with = now.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        System.out.println(with);
        //当然TemporalAdjusters还可以做的事情有很多，但这部分目前不是重点，有兴趣可以自己去看看
    }
}
