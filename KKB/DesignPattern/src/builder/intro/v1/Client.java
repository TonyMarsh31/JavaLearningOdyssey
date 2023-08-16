package builder.intro.v1;

import builder.intro.v1.builder.BMWBuilder;
import builder.intro.v1.builder.BenzBuilder;
import builder.intro.v1.car.BMW;
import builder.intro.v1.car.Benz;

import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        //定义启动顺序
        ArrayList<String> sequence = new ArrayList<>();
        sequence.add("start");
        sequence.add("stop");
        sequence.add("alarm");
        sequence.add("engineBoom");

        //创建一个BenzBuilder对象
        BenzBuilder benzBuilder = new BenzBuilder();
        //设置顺序
        benzBuilder.setSequence(sequence);
        //生产
        Benz benz = (Benz) benzBuilder.getCarModel();
        benz.run();

        //按照同样的顺序，再来一个宝马车
        BMWBuilder bmwBuilder = new BMWBuilder();
        bmwBuilder.setSequence(sequence);
        BMW bmw = (BMW) bmwBuilder.getCarModel();
        bmw.run();
    }
}
