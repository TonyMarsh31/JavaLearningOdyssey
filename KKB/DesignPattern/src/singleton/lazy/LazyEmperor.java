package singleton.lazy;

/**
 * 皇帝类
 * 懒汉式的单例模式，同时实现了线程安全
 */
public class LazyEmperor {
    //保证emperor对象在所有线程中同步
    private static volatile LazyEmperor emperor = null;

    //私有构造方法，避免在类的外部创建对象
    private LazyEmperor() {
    }

    //提供一个产生实例的方法
    public static synchronized LazyEmperor getInstance() {
        if (emperor == null) {
            emperor = new LazyEmperor();
        }
        return emperor;
    }

    public void work() {
        System.out.println("我是皇帝XXX：有事起奏，无事退朝！");
    }
}
