package observer.intro;

import java.util.ArrayList;

public class Celebrity1 implements IStar, Observable {
    /**
     * 观察名人的 人群集合
     */
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    private String name;

    public Celebrity1(String name) {
        this.name = name;
    }

    @Override
    public void eat() {
        System.out.println(name + " is eating");
        this.notifyObserver(name + " is eating");
    }

    @Override
    public void action() {
        System.out.println(name + " is doing something");
        this.notifyObserver(name + " is doing something");
    }


    /**
     * 添加一个观察者
     *
     * @param observer 谁盯着那些明星在看
     */
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);

    }

    /**
     * 删除一个观察者
     *
     * @param observer 观察者
     */
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * 当明星有行动时，通知(被暴露给)观察者
     *
     * @param message 明星的行动
     */
    @Override
    public void notifyObserver(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
