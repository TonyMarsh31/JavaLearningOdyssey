package observer.intro;

public class Fans implements Observer {
    /**
     * 一旦发现明星有行动，就要做出相应的反应
     *
     * @param context 明星的行动
     */
    @Override
    public void update(String context) {
        System.out.println("粉丝观察到了明星的活动:" + context);
        this.action(context);
    }

    private void action(String context) {
        System.out.println("粉丝在观察到明星后在欢呼雀跃");
    }
}
