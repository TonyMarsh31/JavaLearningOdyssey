package template.v2;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        System.out.println("H1型号的Hummer");
        System.out.println("是否需要鸣笛功能：0-不需要，1-需要");
        String type = new Scanner(System.in).next();


        HummerH1 hummerH1 = new HummerH1();
        hummerH1.setAlarmFlag("1".equals(type));
        hummerH1.run();

        HummerH2 hummerH2 = new HummerH2();
        hummerH2.run();
    }
}
