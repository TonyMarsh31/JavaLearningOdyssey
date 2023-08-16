package observer.universal;

public class ConcreteObserver2 implements Observer {
    @Override
    public void updateSelf() {
        System.out.println("ConcreteObserver2: 我是观察者2，我收到了目标发生改变的通知，我要更新自己的状态...");
    }
}
