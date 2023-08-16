package observer.intro;

public class Client {
    public static void main(String[] args) {
        //三个具体的观察者
        Observer fan = new Fans();
        Observer journalist = new Journalist();
        Observer taobaoShop = new TaobaoShop();
        //定义被观察者
        Celebrity1 celebrity1 = new Celebrity1("张三");
        //三个观察者都在观察着Celebrity1
        celebrity1.addObserver(fan);
        celebrity1.addObserver(journalist);
        celebrity1.addObserver(taobaoShop);
        //Celebrity1发生了一些事情
        celebrity1.eat();
        celebrity1.action();
    }
}
