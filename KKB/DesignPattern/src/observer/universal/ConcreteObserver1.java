package observer.universal;

public class ConcreteObserver1 implements Observer {
    /**
     * 反应
     */
    @Override
    public void updateSelf() {
        System.out.println("ConcreteObserver1: 我是观察者1，我收到了目标发生改变的通知，我要更新自己的状态...");
    }
}
