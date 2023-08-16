package observer.intro;

public class TaobaoShop implements Observer {
    /**
     * 一旦发现明星有行动，就要做出相应的反应
     *
     * @param context 明星的行动
     */
    @Override
    public void update(String context) {
        System.out.println("TaobaoShop,观察到明星的行动 " + context);
        this.action(context);
    }

    private void action(String context) {
        System.out.println("TaobaoShop开始自己的行动……");
    }
}
