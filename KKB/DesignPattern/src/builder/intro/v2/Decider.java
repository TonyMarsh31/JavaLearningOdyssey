package builder.intro.v2;

import builder.intro.v2.builder.BMWBuilder;
import builder.intro.v2.builder.BenzBuilder;
import builder.intro.v2.car.BMW;
import builder.intro.v2.car.Benz;

import java.util.ArrayList;

public class Decider {
    private ArrayList<String> sequence = new ArrayList<>();
    private BenzBuilder benzBuilder = new BenzBuilder();
    private BMWBuilder bmwBuilder = new BMWBuilder();

    /**
     * 奔驰模型A，先start,后停止，没有其他操作
     */
    public Benz getBenzVersionA() {
        this.sequence.clear();
        this.sequence.add("start");
        this.sequence.add("stop");
        this.benzBuilder.setSequence(sequence);
        return (Benz) this.benzBuilder.getCarModel();
    }

    /**
     * 奔驰模型B，先发动引擎，后start，后停止，没有其他操作
     */
    public Benz getBenzVersionB() {
        this.sequence.clear();
        this.sequence.add("engineBoom");
        this.sequence.add("start");
        this.sequence.add("stop");
        this.benzBuilder.setSequence(sequence);
        return (Benz) this.benzBuilder.getCarModel();
    }

    /**
     * 宝马模型C
     */
    public BMW getBMWVersionC() {
        this.sequence.clear();
        this.sequence.add("start");
        this.sequence.add("engineBoom");
        this.sequence.add("alarm");
        this.sequence.add("stop");
        this.bmwBuilder.setSequence(sequence);
        return (BMW) this.bmwBuilder.getCarModel();
    }

    //其他内容:其他顺序的模型自行定义
}
