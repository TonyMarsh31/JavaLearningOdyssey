package builder.intro.v2;

import builder.intro.v2.car.BMW;
import builder.intro.v2.car.Benz;

public class Client {
    public static void main(String[] args) {
        Decider decider = new Decider();
        Benz benz = decider.getBenzVersionA();
        benz.run();
        System.out.println("\n");
        Benz benz2 = decider.getBenzVersionB();
        benz2.run();
        System.out.println("\n");
        BMW bmw = decider.getBMWVersionC();
        bmw.run();
    }
}
