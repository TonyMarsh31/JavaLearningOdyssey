package template.v2;

public class HummerH1 extends HummerModel {
    private boolean alarmFlag = true;//默认开启喇叭

    public void setAlarmFlag(boolean alarmFlag) {
        this.alarmFlag = alarmFlag;
    }

    @Override
    public void start() {
        System.out.println("H1 start");
    }

    @Override
    public void stop() {
        System.out.println("H1 stop");
    }

    @Override
    public void alarm() {
        System.out.println("H1 alarm");
    }

    @Override
    public void engineBoom() {
        System.out.println("H1 engine boom");
    }

    @Override
    protected boolean isAlarm() {
        return this.alarmFlag;
    }
}
