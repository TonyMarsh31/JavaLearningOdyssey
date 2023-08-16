package builder.intro;

import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        Benz benz = new Benz();
        //自定义启动顺序
        ArrayList<String> bootOrder = new ArrayList<>();
        bootOrder.add("start");
        bootOrder.add("stop");
        bootOrder.add("alarm");
        bootOrder.add("engineBoom");
        benz.setSequence(bootOrder);
        benz.run();
    }
}
