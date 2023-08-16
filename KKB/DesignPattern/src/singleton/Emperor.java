package singleton;

/**
 * 皇帝类
 */
public class Emperor {

    private static Emperor emperor = null;

    //私有构造方法，避免在类的外部创建对象
    private Emperor() {
    }

    //提供一个产生实例的方法
    public static Emperor getInstance() {
        if (emperor == null) {
            emperor = new Emperor();
        }
        return emperor;
    }

    public void work() {
        System.out.println("我是皇帝XXX：有事起奏，无事退朝！");
    }
}
