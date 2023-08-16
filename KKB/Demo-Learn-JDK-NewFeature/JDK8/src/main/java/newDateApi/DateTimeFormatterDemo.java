package newDateApi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 新的日期格式化API
 */
public class DateTimeFormatterDemo {
    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);
        //时间格式化
        //date->String
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss");
        String format = formatter.format(dateTime);
        System.out.println("Date经过格式化后:\t" + format);
        //String -date
        LocalDateTime parse = LocalDateTime.parse("20221212 12:12:12", formatter);
        System.out.println("String经过格式化后:\t" + parse);
    }
}
