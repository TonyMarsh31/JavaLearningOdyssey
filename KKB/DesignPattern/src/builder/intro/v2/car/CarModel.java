package builder.intro.v2.car;

import java.util.ArrayList;

public abstract class CarModel {
    private ArrayList<String> sequence = new ArrayList<>();

    public void setSequence(ArrayList<String> sequence) {
        this.sequence = sequence;
    }

    protected abstract void start();

    protected abstract void stop();

    protected abstract void alarm();

    protected abstract void engineBoom();

    //启动顺序自定义
    public void run() {
        for (String s : sequence) {
            if ("start".equalsIgnoreCase(s)) {
                this.start();
            } else if ("stop".equalsIgnoreCase(s)) {
                this.stop();
            } else if ("alarm".equalsIgnoreCase(s)) {
                this.alarm();
            } else if ("engineBoom".equalsIgnoreCase(s)) {
                this.engineBoom();
            }
        }
    }
}
