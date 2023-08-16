package TextBlockUpdate;

public class Demo {
    public static void main(String[] args) {
        // \ ⽤于取消换⾏操作
        // \s 表示⼀个空格
        String sql = """
                select \
                * \
                from \
                student\s;
                """;
        System.out.println(sql);
    }
}
