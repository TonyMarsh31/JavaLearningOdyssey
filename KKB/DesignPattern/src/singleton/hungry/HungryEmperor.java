package singleton.hungry;

/**
 * 皇帝类
 * 饿汉式的单例模式，与懒汉式的区别在于：在类加载的时候就创建实例，而懒汉式的是在第一次调用的时候创建实例
 */
public class HungryEmperor {
    //在类加载时便实例化对象，同时使用final修饰来确保对象的唯一性
    private static final HungryEmperor emperor = new HungryEmperor();

    //私有构造方法，避免在类的外部创建对象
    private HungryEmperor() {
    }

    //提供实例的方法
    public static HungryEmperor getInstance() {
        return emperor;
    }

    public void work() {
        System.out.println("我是皇帝XXX：有事起奏，无事退朝！");
    }
}
