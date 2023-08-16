package abstractfactory.universal.factory;

import abstractfactory.universal.product.AbstractProductA;
import abstractfactory.universal.product.AbstractProductB;
import abstractfactory.universal.product.AbstractProductC;

/**
 * 抽象工厂类
 */
public abstract class AbstractCreator {
    //创建A产品家族
    public abstract AbstractProductA createProductA();

    //创建B产品家族
    public abstract AbstractProductB createProductB();

    //创建C产品家族
    public abstract AbstractProductC createProductC();
    //如果有N个产品族，该类中应该有N个创建方法
}
