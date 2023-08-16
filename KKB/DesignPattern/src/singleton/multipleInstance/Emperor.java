package singleton.multipleInstance;

import java.util.ArrayList;
import java.util.Random;

/**
 * 单例模式，但是有多个(固定个数的)实例需求
 */
public class Emperor {
    private String name;
    private static final  int maxNum=2;
    //实现的方法是将实例对象存入用final修饰的List中，然后随机获取一个实例对象
    private static final ArrayList<Emperor> list=new ArrayList<>(2);
    static {
            list.add(new Emperor("皇帝：朱祁镇"));
            list.add(new Emperor("皇帝：朱祁钰"));
    }
    //构造方法私有，避免在类的外部创建对象
    private Emperor() {
    }

    private Emperor(String name) {
        this.name = name;
    }

    //提供一个产生实例的方法
    public static Emperor getInstance(){
        int index=new Random().nextInt(maxNum);//随机获取一个实例对象
        return list.get(index);
    }
    public void work(){
        System.out.println("我是皇帝"+name+"：有事起奏，无事退朝！");
    }
}
