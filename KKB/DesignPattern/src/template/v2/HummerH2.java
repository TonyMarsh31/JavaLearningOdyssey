package template.v2;

public class HummerH2 extends HummerModel {
    @Override
    public void start() {
        System.out.println("H2 start");
    }

    @Override
    public void stop() {
        System.out.println("H2 stop");
    }

    @Override
    public void alarm() {
        System.out.println("H2 alarm");
    }

    @Override
    public void engineBoom() {
        System.out.println("H2 engine boom");
    }

    //默认不会响喇叭
    @Override
    protected boolean isAlarm() {
        return false;
    }
}
