package SwitchExpression;

public class OldDays {
    public static void main(String[] args) {
        DAY day = DAY.FRIDAY;
        switch (day) {
            case MONDAY:
                System.out.println(1);
                break;
            case TUESDAY:
                System.out.println(2);
                break;
            case WEDNESDAY:
                System.out.println(3);
                break;
            case THURSDAY:
                System.out.println(4);
                break;
            case FRIDAY:
                System.out.println(5);
                break;
            case SATURDAY:
                System.out.println(6);
                break;
            case SUNDAY:
                System.out.println(7);
                break;
            default:
                System.out.println("error");
                break;
        }
    }
}