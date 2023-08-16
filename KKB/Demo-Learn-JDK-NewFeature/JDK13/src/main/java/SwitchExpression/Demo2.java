package SwitchExpression;

/**
 * 增强型switch语句在13中仍然是preview特性，所以代码不能通过编译。
 */
public class Demo2 {
    public static void main(String[] args) {
        DAY day = DAY.FRIDAY;
        int numLetters = switch (day) {
            case MONDAY, FRIDAY, SUNDAY:
                yield 6;
            case TUESDAY:
                yield 7;
            case THURSDAY, SATURDAY:
                yield 8;
            case WEDNESDAY:
                yield 9;
            default:
                throw new IllegalStateException("Wat: " + day);
        };
        System.out.println(numLetters);
    }
}
