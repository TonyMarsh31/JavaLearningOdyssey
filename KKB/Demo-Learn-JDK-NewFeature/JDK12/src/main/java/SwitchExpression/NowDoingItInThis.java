package SwitchExpression;

/**
 * 增强的switch语句虽然在JDk12中首次出现，但是其是作为预览特性。
 * 直到JDK14,增强switch语句才被正式支持。
 * 所以以下代码在JDK12中不能编译通过，但是在JDK14中可以编译通过。
 */
public class NowDoingItInThis {
    public static void main(String[] args) {
        /*DAY day = DAY.FRIDAY;
        //原来繁琐的switch语句现在可以被简化为如下形式
        switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> System.out.println(6);
            case TUESDAY -> System.out.println(7);
            case THURSDAY, SATURDAY -> System.out.println(8);
            case WEDNESDAY -> System.out.println(9);
        }

        //增强的switch语句还可以用于赋值变量
        int i = switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY -> 7;
            case THURSDAY, SATURDAY -> 8;
            case WEDNESDAY -> 9;
            default -> 0;
        };

        //每一个case都可以定义自己独立的代码块
        switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> {int i = 6; System.out.println(i);}
            case TUESDAY -> {int i = 7; System.out.println(i);}
            case THURSDAY, SATURDAY -> {int i = 8; System.out.println(i);}
            case WEDNESDAY -> {int i = 9; System.out.println(i);}
            default -> {int i = 10; System.out.println(i);}
        }
        */
    }
}
